package com.capgemini.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cart.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer>{

	public Cart findById(int cartId);
}
