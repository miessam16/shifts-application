package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.services.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationsController {
    @Autowired
    private ApplicationsService applicationsService;
}
