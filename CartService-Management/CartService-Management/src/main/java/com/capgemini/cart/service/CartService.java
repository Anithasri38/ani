package com.capgemini.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.cart.models.Cart;



@Service
public interface CartService {

	public Cart getCartById(int cartId);
	public Cart updateCart(int cartId,Cart cart);
	public List<Cart> getAllCarts();
	public double cartTotal(Cart cart);
	public Cart addCart(Cart cart);
	public void deleteCart(int cartId);
}
