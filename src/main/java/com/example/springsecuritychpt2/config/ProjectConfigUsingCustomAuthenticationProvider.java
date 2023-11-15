package com.example.springsecuritychpt2.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 2.3.4 CustomAuthenticationProvider
 * curl http://localhost:8080/hello -v
 * curl -u john:12345 http://localhost:8080/hello
 */
@SuppressWarnings({
		"deprecation",           // 테스트 위함
		"JavadocLinkAsPlainText", // 학습목적
		"unused"                 //학습 목적
		, "CommentedOutCode"        // 학습목적
})
//@Configuration
public class ProjectConfigUsingCustomAuthenticationProvider extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("FieldCanBeLocal") // @Configuration 사용하면 주입받는게 맞음 (local variable 로 바꾸면 안됨)
	private final CustomAuthenticationProvider customAuthenticationProvider;
	public ProjectConfigUsingCustomAuthenticationProvider(CustomAuthenticationProvider customAuthenticationProvider) {
		this.customAuthenticationProvider = customAuthenticationProvider;
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {
//		auth.authenticationProvider(customAuthenticationProvider);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests()
				.anyRequest().authenticated();
	}
}
