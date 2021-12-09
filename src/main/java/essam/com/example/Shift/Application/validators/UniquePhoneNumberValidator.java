package essam.com.example.Shift.Application.validators;

import essam.com.example.Shift.Application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Boolean isExists = userRepository.existsByPhoneNumber(s);
        return !isExists;
    }
}
