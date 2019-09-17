package ch.nyp.noa.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the SpringFox/Swagger configuration
 *
 * @author Yves Kaufmann
 */
@Configuration
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfiguration {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select().apis(RequestHandlerSelectors.basePackage("ch.nyp.noa.webContext.domain")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Prototype Rest API").description("Description of Prototype Rest API")
				.termsOfServiceUrl("").contact(new Contact("Noser Young", "Lorem Ipsum1", "zuerich@noseryoung.ch")).license("")
				.licenseUrl("").version("1.0").build();
	}

	@Bean
	public UiConfiguration uiConfiguration() {
		return UiConfigurationBuilder.builder()
				.operationsSorter(OperationsSorter.METHOD)
				.build();
	}

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
		return () -> {
			SwaggerResource wsResource = new SwaggerResource();
			wsResource.setName("Default");
			wsResource.setSwaggerVersion("2.0");
			wsResource.setLocation("/swagger.yaml");

			List<SwaggerResource> resources = new ArrayList<>();
			resources.add(wsResource);
			return resources;
		};
	}
	
}