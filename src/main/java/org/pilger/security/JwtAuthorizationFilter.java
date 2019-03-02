package org.pilger.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtAuthorizationFilter extends GenericFilterBean {
    private final static String HEADER_STRING="Authorization";


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	       System.out.println("IN FILTER");
	        String header = ((HttpServletRequest) request).getHeader("Authorization");

	        if (header == null || !header.startsWith("Bearer")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        String token = ((HttpServletRequest) request).getHeader(HEADER_STRING);
	        if (validateMyToken(token)) {
	            List<String> mygroups = getMyGroups(token);
	        } else {
	            throw new InvalidTokenException("Token is not Ok :(");
	        }
		
	}


}