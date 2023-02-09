package com.example.shoppingcart.profile.exception;

public class ProfileNotFoundException extends RuntimeException{

private String message;
	
	public ProfileNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	public ProfileNotFoundException() {
		
	}
		
}
