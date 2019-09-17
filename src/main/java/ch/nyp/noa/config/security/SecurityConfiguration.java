package ch.nyp.noa.config.security;

import ch.nyp.noa.config.PropertyReader;
import ch.nyp.noa.webContext.domain.user.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class is the main security context
 *
 * @author Yves Kaufmann
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private UserService userService;
	
	private BCryptPasswordEncoder pwEncoder;
	
	private PropertyReader propertyReader;
	
	private Logger errorLogger;
	
	/**
	 * @param userService
	 * @param pwEncoder
	 */
	@Autowired
	public SecurityConfiguration(
			UserService userService, BCryptPasswordEncoder pwEncoder, @Qualifier("webErrorLogger") Logger errorLogger
	) {
		super();
		this.userService = userService;
		this.pwEncoder = pwEncoder;
		this.errorLogger = errorLogger;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(pwEncoder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		propertyReader = new PropertyReader("jwt.properties");
		http.csrf().disable().authorizeRequests()
				.antMatchers("/welcome", "/login", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
						"/webjars/**", "/**")
				.permitAll().anyRequest().authenticated().and()
				.addFilterAfter(
						new JWTAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"),
								authenticationManagerBean(), propertyReader),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(
						new JWTAuthorizationFilter(userService, propertyReader, errorLogger::warn), // TODO adjust logging of
																									// invalid JWTs to specific
																									// project requirements (this
																									// is a prototype)
						UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
