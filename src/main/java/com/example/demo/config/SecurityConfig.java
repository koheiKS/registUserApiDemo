package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/css/**", "/img/**", "/js/**", "/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認可に対する制限をGET、POSTとも解除している。本番では見直した方が良いかも
		http.authorizeRequests()
			.antMatchers("/", "/greeting", "/regist-pokemon", "/regist-pokedex", "/users").permitAll()
			.antMatchers().hasRole("ADMIN")
            .antMatchers().hasRole("USER")
			.anyRequest().authenticated();

		http.csrf().disable();
	}
}
