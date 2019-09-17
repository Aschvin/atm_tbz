package ch.nyp.noa.config.security;

import ch.nyp.noa.config.PropertyReader;
import ch.nyp.noa.webContext.domain.user.UserDetailsImpl;
import ch.nyp.noa.webContext.domain.user.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * This class handles the authorization and JWT parsing process 
 *
 * @author Yves Kaufmann
 */
class JWTAuthorizationFilter extends OncePerRequestFilter {

	private UserService userService;
	
	private PropertyReader propertyReader;

	private Consumer<String> errorLogger;
	
	/**
	 * @param authenticationManager
	 * @param userServiceImpl
	 * @param propertyReader
	 */
	JWTAuthorizationFilter(UserService userService,
			PropertyReader propertyReader, Consumer<String> errorLogger) {
		this.userService = userService;
		this.propertyReader = propertyReader;
		this.errorLogger = errorLogger;
	}

	/**
	 * This method aligns and compares header with internal properties
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(propertyReader.getStringProperty("jwt.header-string"));
		if (header != null && header.startsWith(propertyReader.getStringProperty("jwt.token-prefix"))) {
			SecurityContextHolder.getContext().setAuthentication(getAuthentication(req, header));
		}
		chain.doFilter(req, res);
	}

	/**
	 * This method parses JWT and puts content into an authenticationToken
	 *
	 * @param req    Client request
	 * @param header Header string
	 * @return UsernamePasswordAuthenticationToken
	 */
	private Authentication getAuthentication(HttpServletRequest req, String header) {
		String subject;
		try {
			subject = Jwts.parser()
					.setSigningKey(propertyReader.getStringProperty("jwt.secret").getBytes())
					.parseClaimsJws(header.replace(propertyReader.getStringProperty("jwt.token-prefix"), "")).getBody()
					.getSubject();
		} catch (ExpiredJwtException ex) {
			errorLogger.accept("Expired JWT was given: " + header);
			return null;
		}
		
		if (subject != null) {
			UserDetailsImpl userDetails = new UserDetailsImpl(userService.findById(Long.parseLong(subject)));
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		}
		return null;
	}

}