package com.example.springsecuritychpt2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	/**
	 * allows
	 * curl -u john:12345 http://localhost:8080/hello
	 */
	@SuppressWarnings("JavadocLinkAsPlainText")
	@Bean
	public UserDetailsService userDetailsService(){
		var userDetailsService = new InMemoryUserDetailsManager();

		var user = User.withUsername("john")
				.password("12345")
				.authorities("read")
				.build();

		userDetailsService.createUser(user);

		return userDetailsService;
	}

	@Bean
	@SuppressWarnings("deprecation") // NoOpPasswordEncoder 는 개발용으로 사용하라는 의미로 Deprecated 되어있음
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();

		// 모든 요청에 승인이 필요하다.
//		http.authorizeRequests()
//				.anyRequest().authenticated();

		// 인증 없이 요청할 수 있다.
		http.authorizeRequests()
				.anyRequest().permitAll();

	}


}
