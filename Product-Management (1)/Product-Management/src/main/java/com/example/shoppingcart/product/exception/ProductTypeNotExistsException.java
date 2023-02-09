package com.example.shoppingcart.product.exception;

public class ProductTypeNotExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ProductTypeNotExistsException(String message) {
		
		super(message);
	}
		
		
		
	public ProductTypeNotExistsException() {
		
	}
}
