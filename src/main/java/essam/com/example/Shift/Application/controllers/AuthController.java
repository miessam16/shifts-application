package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.requests.LoginRequest;
import essam.com.example.Shift.Application.requests.RegisterRequest;
import essam.com.example.Shift.Application.responses.LoginResponse;
import essam.com.example.Shift.Application.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController extends BaseController {
    @Autowired
    private AuthService authService;

    @PostMapping(path = "register")
    public ResponseEntity<User> register(@Valid @RequestBody final RegisterRequest body) {
        return new ResponseEntity<User>(authService.register(body), HttpStatus.OK);
    }

    @PostMapping(path = "login")
    public LoginResponse login(@Valid @RequestBody final LoginRequest body) {
        return new LoginResponse(authService.login(body));
    }
}
