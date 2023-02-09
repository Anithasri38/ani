package com.example.shoppingcart.product.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingcart.product.models.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{

	public List<Product> findByProductName(String productName);

	public List<Product> findByCategory(String category);

	public List<Product> findByProductType(String producType);
}
