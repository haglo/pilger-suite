package org.pilger.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Username: pilgeruser, Password: 1234atgfd
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticatedUserDetailService userDetailService;

    public SecurityConfig(AuthenticatedUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(new JwtFilter(userDetailService));
    }
}


//
//	public boolean makeMeSystemUser() {
//        if (SecurityUtils.getCurrentUserLogin() != null) return false; //Not allowed in request-scope!
//        RunAsUserToken asUserToken = new RunAsUserToken(Constants.SYSTEM_ACCOUNT, Constants.SYSTEM_ACCOUNT, null, null, null);
//        asUserToken.setAuthenticated(true);
//        SecurityContextHolder.getContext().setAuthentication(asUserToken);
//        return true;
//    }


