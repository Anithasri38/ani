package com.example.spring.security.jpa.learnspringsecurityjpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.spring.security.jpa.learnspringsecurityjpa.model.User;

public class MyUserDetails implements UserDetails{
	 private String username;
	 private String password; 
	 private boolean active;
	 private List<GrantedAuthority> authorities;
	 
     public MyUserDetails(User user)
     {
    	this.username=user.getUsername();
    	this.password=user.getPassword();
    	this.active=user.isActive();
    	this.authorities=Arrays.stream(user.getRoles().split(","))
    			.map(SimpleGrantedAuthority::new)
    			.collect(Collectors.toList());
     }
    /* public MyUserDetails()
     {
    	 
     }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		
		return "pass";
	}

	@Override
	public String getUsername() {
	
		return username;
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
	}*/

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	   
   
}
