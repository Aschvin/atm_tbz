package ch.nyp.atm.config.validation.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class validates the @{@link Password} Annotation
 * @author Severin Weigold
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) throws RuntimeException {
        //TODO validate password according to project-specific standards

        return true;
    }

}
