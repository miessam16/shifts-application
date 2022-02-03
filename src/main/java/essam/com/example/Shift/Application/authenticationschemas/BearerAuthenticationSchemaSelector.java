package essam.com.example.Shift.Application.authenticationschemas;

import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.services.AuthService;
import org.lognet.springboot.grpc.security.AuthenticationSchemeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BearerAuthenticationSchemaSelector implements AuthenticationSchemeSelector {
    @Autowired
    private AuthService authService;

    @Override
    public Optional<Authentication> getAuthScheme(CharSequence authorization) {
        if (authorization.isEmpty() || !authorization.toString().startsWith("Bearer ")) {
            return Optional.empty();
        }

        String token = authorization.toString().substring(7);
        User user = authService.getUserByToken(token);

        if (user == null) {
            return Optional.empty();
        }

        return Optional.of(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
    }
}
