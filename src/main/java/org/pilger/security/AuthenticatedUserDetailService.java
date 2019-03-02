package org.pilger.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.pilger.model.entity.*;
import org.pilger.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class AuthenticatedUserDetailService implements UserDetailsService {

	@Autowired
	private CurrentUserRepository repository;

	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CurrentUser currentUser = repository.findByUsername(username);

		return withUsername(currentUser.getUsername()).password("").authorities(currentUser.getRoles().stream().map(Role::getRolename).collect(Collectors.joining())).accountExpired(false)
				.accountLocked(false).credentialsExpired(false).disabled(false).build();
	}

	/**
	 * Extract username and roles from a validated jwt string.
	 *
	 * @param jwtToken jwt string
	 * @return UserDetails if valid, Empty otherwise
	 */
	public Optional<UserDetails> loadUserByJwtToken(String jwtToken) {
		if (jwtProvider.isValidToken(jwtToken)) {
			return Optional.of(withUsername(jwtProvider.getUsername(jwtToken))
					.authorities(jwtProvider.getRoles(jwtToken)).password("") // token does not have password but field may not be emtpy																				// may not be empty
					.accountExpired(false).accountLocked(false).credentialsExpired(false).disabled(false).build());
		}
		return Optional.empty();
	}

	/**
	 * Extract the username from the JWT then lookup the user in the database.
	 *
	 * @param jwtToken
	 * @return
	 */
	public Optional<UserDetails> loadUserByJwtTokenAndDatabase(String jwtToken) {
		if (jwtProvider.isValidToken(jwtToken)) {
			return Optional.of(loadUserByUsername(jwtProvider.getUsername(jwtToken)));
		} else {
			return Optional.empty();
		}
	}
}
