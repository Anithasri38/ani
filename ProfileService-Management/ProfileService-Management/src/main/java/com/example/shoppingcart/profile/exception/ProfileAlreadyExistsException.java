package com.example.shoppingcart.profile.exception;

public class ProfileAlreadyExistsException extends RuntimeException{

private String message;
	
	public ProfileAlreadyExistsException(String message) {
		super(message);
		this.message=message;
	}
	public ProfileAlreadyExistsException() {
		
	}
}
