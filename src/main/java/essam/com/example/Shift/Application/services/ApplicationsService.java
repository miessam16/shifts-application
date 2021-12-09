package essam.com.example.Shift.Application.services;

import essam.com.example.Shift.Application.models.Application;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.repositories.ApplicationRepository;
import essam.com.example.Shift.Application.repositories.ShiftRepository;
import essam.com.example.Shift.Application.requests.CreateApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicationsService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    public Application create(User user, CreateApplicationRequest request, Long shiftId) {
        Shift shift = this.shiftRepository.findById(shiftId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shift Not Found"));

        if (shift.getCreator().getId() == user.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cannot apply to your shift");
        }

        Integer numberOfShiftsInShiftTime = this.shiftRepository.countByAssigneeInRange(user.getId(), shift.getStartTime(), shift.getEndTime());

        if (numberOfShiftsInShiftTime > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is not available in shift time");
        }

        Boolean hasAppliedBefore = this.applicationRepository.existsByApplicantAndShift(user, shift);

        if (hasAppliedBefore) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User has applied before");
        }

        return this.applicationRepository.saveAndFlush(new Application(shift, user, request));
    }
}
