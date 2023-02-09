package com.capgemini.cart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cart.exception.CartAlreadyExistsException;
import com.capgemini.cart.exception.CartNotFoundException;
import com.capgemini.cart.models.Cart;
import com.capgemini.cart.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
	Logger logger=LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
     CartRepository cartRepository;
	@Override
	public Cart getCartById(int cartId)throws CartNotFoundException
	{
		if(cartRepository.existsById(cartId))
		{		
		  logger.info("Cart details of cartId:"+cartId);	
		   return cartRepository.findById(cartId);
		}
		else
		{
			logger.warn("Cart not found with cartId:"+cartId);
			throw new CartNotFoundException("CartId:"+cartId+" not found");
		}
	}
	@Override
	public Cart updateCart(int cartId, Cart cart)throws CartNotFoundException {
	   if(cartRepository.existsById(cartId))
	   {  
	      Cart updatedCart=cartRepository.findById(cartId);
	      updatedCart.setCartId(cartId);
	      updatedCart.setItems(cart.getItems());
	      updatedCart.setTotalPrice(cart.getTotalPrice());
	      cartRepository.save(updatedCart);
	      return updatedCart;
	   }  
	   else
	   {
		   throw new CartNotFoundException("CartId:"+cartId+" not found");
	   }
	}
	@Override
	public List<Cart> getAllCarts() throws CartNotFoundException{
		List<Cart> cart=cartRepository.findAll();
		if(cart.isEmpty())
		{
			throw new CartNotFoundException("No available carts");
		}
		else
		{
			return cart;
		}
	}
	@Override
	public double cartTotal(Cart cart) {
		
		return cart.getTotalPrice();
	}
	@Override
	public Cart addCart(Cart cart)throws CartAlreadyExistsException {
		
		return cartRepository.save(cart);
	}
	@Override
	public void deleteCart(int cartId) {
		
	     cartRepository.deleteById(cartId);
	}
	
}
