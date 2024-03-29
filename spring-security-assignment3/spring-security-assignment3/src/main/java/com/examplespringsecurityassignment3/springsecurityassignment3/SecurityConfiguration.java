package com.examplespringsecurityassignment3.springsecurityassignment3;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("anitha")
			    .password("user")
			    .roles("USER")
				)
		.withUser(
				User.withUsername("surya")
			    .password("admin")
			    .roles("ADMIN")
				);
	}
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	

	 
}
