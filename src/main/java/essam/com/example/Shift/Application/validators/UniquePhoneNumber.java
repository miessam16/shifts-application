package essam.com.example.Shift.Application.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniquePhoneNumber {
    String message() default "Phone number already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
