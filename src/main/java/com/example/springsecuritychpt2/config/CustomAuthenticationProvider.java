package com.example.springsecuritychpt2.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

/**
 * 2.3.4 CustomAuthenticationProvider
 */
//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 인증 논리 추가
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		if ( "john".equals(username) && "12345".equals(password) ){
			return new UsernamePasswordAuthenticationToken(username, password, List.of());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Error in authentication!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		// Authentication 형식 구현할 위치
		return UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authenticationType);
	}
}
