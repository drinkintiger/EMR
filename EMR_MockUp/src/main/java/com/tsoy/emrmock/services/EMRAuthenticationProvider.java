package com.tsoy.emrmock.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("eMRAuthenticationProvider")
public class EMRAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private com.tsoy.emrmock.domain.security.UserDao userDao;

	public EMRAuthenticationProvider() {
		System.out.println("CONSTRUCTING EMRAUTHENTICATIONPROVIDER");
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		System.out.println("AUTHENTICATE:" + username + "," + password);
		com.tsoy.emrmock.domain.security.User user = userDao.findUserByUsername(username);

		if (user == null) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(username, encodedPassword, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
