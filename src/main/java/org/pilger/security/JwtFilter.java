package org.pilger.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * Filter for Java Web Token Authentication and Authorization
 *
 * Created by Mary Ellen Bowman
 */
public class JwtFilter extends GenericFilterBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);
	private static final String BEARER = "Bearer";
	private static final String HEADER_STRING="Authorization";
	private Integer ctr = 0;

	private AuthenticatedUserDetailService authenticatedUserDetailService;

	public JwtFilter(AuthenticatedUserDetailService userDetailService) {
		this.authenticatedUserDetailService = userDetailService;
	}

	/**
	 * Determine if there is a JWT as part of the HTTP Request Header. If it is
	 * valid then set the current context With the Authentication(user and roles)
	 * found in the token
	 *
	 * @param request         Servlet Request
	 * @param response         Servlet Response
	 * @param filterChain Filter Chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		LOGGER.info("Check - JSON Web Token " + ctr);
		// Read http-Request
		String jwtToken = ((HttpServletRequest) request).getHeader(HEADER_STRING);
		getBearerToken(jwtToken).ifPresent(token -> {
			LOGGER.info("Find -  JSON Web Token " + ctr);
			authenticatedUserDetailService.loadUserByJwtToken(token).ifPresent(userDetails -> {
				SecurityContextHolder.getContext().setAuthentication(
						new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
			});
		});

		ctr++;
		// move on to the next filter in the chains
		filterChain.doFilter(request, response);

	}

	/**
	 * if present, extract the jwt token from the "Bearer <jwt>" header value.
	 *
	 * @param token
	 * @return jwt if present, empty otherwise
	 */
	private Optional<String> getBearerToken(String token) {
		if (token != null && token.startsWith(BEARER)) {
			return Optional.of(token.replace(BEARER, "").trim());
		}
		return Optional.empty();
	}
}