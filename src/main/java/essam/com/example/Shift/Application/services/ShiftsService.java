package essam.com.example.Shift.Application.services;

import essam.com.example.Shift.Application.enums.ShiftStatus;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.repositories.ShiftRepository;
import essam.com.example.Shift.Application.requests.CreateShiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShiftsService {
    @Autowired
    private ShiftRepository shiftRepository;

    public Shift create(User creator, CreateShiftRequest request) {
        return shiftRepository.saveAndFlush(new Shift(creator, request));
    }

    public Page<Shift> find(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return shiftRepository.findAllByStatus(ShiftStatus.SCHEDULED, pageable);
    }
}
