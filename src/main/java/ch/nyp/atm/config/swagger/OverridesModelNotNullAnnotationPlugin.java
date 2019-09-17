package ch.nyp.atm.config.swagger;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.schema.NotNullAnnotationPlugin;

/**
 * @author Severin Weigold
 *
 * This class makes the Swagger-UI order the displayed endpoints by their HTTP-Method
 */
@Component
@Order
public class OverridesModelNotNullAnnotationPlugin extends NotNullAnnotationPlugin {
}
