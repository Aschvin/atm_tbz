package ch.nyp.noa.config.validation.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * This Annotation indicates that the value of an annotated field must be a valid password
 * @author Severin Weigold
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    int length() default 5;
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
