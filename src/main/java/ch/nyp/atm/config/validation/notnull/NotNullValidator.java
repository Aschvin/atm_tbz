package ch.nyp.atm.config.validation.notnull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class validates the @{@link NotNull} Annotation
 * @author Severin Weigold
 */
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value != null && !"null".equalsIgnoreCase(value.toString());
    }
}
