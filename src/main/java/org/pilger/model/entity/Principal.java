package org.pilger.model.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Principal implements UserDetails{
	
 	private static final long serialVersionUID = 1L;
	private CurrentUser currentUser;
    private List<Role> roles;
    
    public Principal(CurrentUser currentUser, List<Role> roles){
        super();
        this.currentUser = currentUser;
        this.roles = roles;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	       if(null==roles){
	            return Collections.emptySet();
	        }
	        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
	        roles.forEach(group->{
	           grantedAuthorities.add(new SimpleGrantedAuthority(group.getRolename()));
	        });
	        return grantedAuthorities;
	}

	@Override
	public String getPassword() {
        return "";
	}

	@Override
	public String getUsername() {
        return this. currentUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
