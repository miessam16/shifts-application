package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.models.Application;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.services.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationsController {
    @Autowired
    private ApplicationsService applicationsService;

    @GetMapping
    public Page<Application> find(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "page") final int page,
            @RequestParam(name = "limit") int limit
    ) {
        return applicationsService.userApplications(user, page, limit);
    }
}
