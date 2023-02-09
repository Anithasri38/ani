package com.example.spring.security.jpa.learnspringsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
  
	 @Autowired 
	 UserDetailsService userDetailsService;
	@Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception 
    {
	    auth.userDetailsService(userDetailsService);   
    }
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()//This tells spring security need to authorize all requests
		.antMatchers("/admin").hasRole("ADMIN")//this tells spring security the /admin url needs to accessed only by admin credentials(role) 
		//.antMatchers("/**").hasRole("ADMIN")All paths Should be accessed by any user
		//.antMatchers("/user").hasRole("USER")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")//this tells spring security the /user url needs to accessed only by any of  admin  or user credentials(role) 
		.antMatchers("/").permitAll()// the / url can be accessed by any role
		.and().formLogin();//type of login
	
    }
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
