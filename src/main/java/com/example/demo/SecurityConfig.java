package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/favicon.ico", "/css/**",
				"/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/add","/login").permitAll()
				.antMatchers("/student/**").hasRole("STUDENT")
				.antMatchers("/teacher/**").hasRole("TEACHER")
				.anyRequest()
				.authenticated();
		http
			.formLogin()
				.loginProcessingUrl("/authenticate")
				.loginPage("/loginForm")
				.failureUrl("/?error")
				.defaultSuccessUrl("/login", true)
				.usernameParameter("loginId")
				.passwordParameter("password")
				.and().logout().logoutSuccessUrl("/").and();
	}

	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}