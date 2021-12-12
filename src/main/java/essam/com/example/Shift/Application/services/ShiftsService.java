package essam.com.example.Shift.Application.services;

import essam.com.example.Shift.Application.enums.ShiftStatus;
import essam.com.example.Shift.Application.models.Application;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.repositories.ApplicationRepository;
import essam.com.example.Shift.Application.repositories.ShiftRepository;
import essam.com.example.Shift.Application.requests.CreateShiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ShiftsService {
    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public Shift create(User creator, CreateShiftRequest request) {
        return shiftRepository.saveAndFlush(new Shift(creator, request));
    }

    public Page<Shift> find(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return shiftRepository.findAllByStatus(ShiftStatus.SCHEDULED, pageable);
    }

    public Shift assign(User user, Long id, Long applicationId) {
        Shift shift = this.shiftRepository.findByIdAndCreatorAndStatus(id, user, ShiftStatus.SCHEDULED).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));
        Application application = this.applicationRepository.findById(applicationId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found"));

        shift.setStatus(ShiftStatus.ASSIGNED);
        shift.setAssignee(application.getApplicant());
        shift.setAssigneeRate(application.getProposedRate());
        shift.setCreatorRate(application.getProposedRate() * 1.2);

        this.shiftRepository.saveAndFlush(shift);
        this.applicationRepository.deleteByApplicantInRange(application.getApplicant().getId(), shift.getStartTime(), shift.getEndTime());

        return shift;
    }

    public Shift clockIn(User user, Long id) {
        Shift shift = this.shiftRepository.findByIdAndAssigneeAndStatus(id, user, ShiftStatus.ASSIGNED).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));

        Date now = new Date();
        long differentInMinutes = TimeUnit.MILLISECONDS.toMinutes(shift.getStartTime().getTime() - now.getTime());

        if (differentInMinutes > 30) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot clock in now");
        }

        shift.setClockIn(new Date());
        shift.setStatus(ShiftStatus.IN_PROGRESS);

        return this.shiftRepository.saveAndFlush(shift);
    }

    public Shift clockOut(User user, Long id) {
        Shift shift = this.shiftRepository.findByIdAndAssigneeAndStatus(id, user, ShiftStatus.IN_PROGRESS).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));

        Date now = new Date();
        Date clockIn = shift.getClockIn();

        if (now.after(shift.getEndTime())) {
            shift.setClockOut(new Date());
        } else {
            shift.setClockOut(now);
        }

        if (clockIn.before(shift.getStartTime())) {
            clockIn = shift.getStartTime();
        }

        long workedMinutes = TimeUnit.MILLISECONDS.toMinutes(shift.getClockOut().getTime() - clockIn.getTime());
        double workedHours = Math.max(workedMinutes / 60.0, 0);

        shift.setStatus(ShiftStatus.COMPLETED);
        shift.setAssigneePayment(Math.round(workedHours * shift.getAssigneeRate() * 100) / 100.0);
        shift.setCreatorPayment(Math.round(workedHours * shift.getCreatorRate() * 100) / 100.0);
        shift.setFees(shift.getCreatorPayment() - shift.getAssigneePayment());

        return this.shiftRepository.saveAndFlush(shift);
    }
}
