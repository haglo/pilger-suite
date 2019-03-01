package org.pilger.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JWTAuthorizationFilter extends GenericFilterBean {
    private final static String HEADER_STRING="Authorization";

    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {

        System.out.println("IN FILTER");
        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(req, res);
            return;
        }
        String token = req.getHeader(HEADER_STRING);
        if (validateMyToken(token)) {
            List<String> mygroups = getMyGroups(token);
        } else {
            throw new InvalidTokenException("Token is not Ok :(");
        }

        #HOW DO I PUT MY GROUPS, SOMEWHERE  FOR VERIFICATION ???
    }
}