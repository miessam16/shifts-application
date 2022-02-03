package essam.com.example.Shift.Application.services;

import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.repositories.UserRepository;
import essam.com.example.Shift.Application.requests.LoginRequest;
import essam.com.example.Shift.Application.requests.RegisterRequest;
import essam.com.example.Shift.Application.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User register(final RegisterRequest request) {
        User user = new User(request.getName(), request.getBio(), request.getPhoneNumber(), passwordEncoder.encode(request.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public String login(final LoginRequest request) throws BadCredentialsException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword()));
        User user = (User) authentication.getPrincipal();
        return jwtTokenUtil.generateToken(user);
    }

    public String login(final essam.com.example.Shift.Application.grpc.LoginRequest request) throws BadCredentialsException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword()));
        User user = (User) authentication.getPrincipal();
        return jwtTokenUtil.generateToken(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        return userRepository.findByPhoneNumber(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User: %s is not found", username)));
    }

    public User getUserByToken(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userRepository.findByPhoneNumber(username).orElse(null);

        if (user != null && this.jwtTokenUtil.validateToken(token, user)) {
            return user;
        }

        return null;
    }
}
