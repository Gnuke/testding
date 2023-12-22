package com.gorea.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.gorea.dto_member.Gorea_UserTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class LoginService implements UserDetails, OAuth2User {
	private Gorea_UserTO gorea_UserTO;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return gorea_UserTO.getGo_user_role();
			}
		});
		return roles;
	}
 
	@Override
	public String getPassword() {
		return gorea_UserTO.getPassword();
	}
 
	@Override
	public String getUsername() {
		
		return gorea_UserTO.getUsername();
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
 
// OAuth2
	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}
 
	@Override
	public String getName() {
		return null;
	}
 
}
