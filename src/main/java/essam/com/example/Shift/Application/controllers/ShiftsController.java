package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.models.Application;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.requests.CreateApplicationRequest;
import essam.com.example.Shift.Application.requests.CreateShiftRequest;
import essam.com.example.Shift.Application.services.ApplicationsService;
import essam.com.example.Shift.Application.services.ShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/shifts")
public class ShiftsController extends BaseController {
    @Autowired
    private ShiftsService shiftsService;

    @Autowired
    private ApplicationsService applicationsService;

    @PostMapping
    public Shift create(@AuthenticationPrincipal User user, @Valid @RequestBody final CreateShiftRequest body) {
        return shiftsService.create(user, body);
    }

    @GetMapping
    public Page<Shift> find(@RequestParam(name = "page") final int page, @RequestParam(name = "limit") int limit) {
        return shiftsService.find(page, limit);
    }

    @PostMapping("{id}/applications")
    public Application create(@AuthenticationPrincipal User user, @Valid @RequestBody final CreateApplicationRequest body, @PathVariable Long id) {
        return applicationsService.create(user, body, id);
    }

    @GetMapping("{id}/applications")
    public Page<Application> findShiftApplications(
            @AuthenticationPrincipal User user,
            @PathVariable Long id,
            @RequestParam(name = "page") final int page,
            @RequestParam(name = "limit") int limit
    ) {
       return applicationsService.findShiftApplications(user, id, page, limit);
    }

    @PostMapping("{id}/applications/{applicationId}/assign")
    public Shift assign(@AuthenticationPrincipal User user, @PathVariable Long id, @PathVariable Long applicationId) {
        return shiftsService.assign(user, id, applicationId);
    }

    @PatchMapping("{id}/startTime")
    public Shift clockIn(@AuthenticationPrincipal User user, @PathVariable Long id) {
        return shiftsService.clockIn(user, id);
    }

    @PatchMapping("{id}/endTime")
    public Shift clockOut(@AuthenticationPrincipal User user, @PathVariable Long id) {
        return shiftsService.clockOut(user, id);
    }
}
