package com.example.shoppingcart.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.product.exception.ProductNotFoundException;
import com.example.shoppingcart.product.models.Product;
import com.example.shoppingcart.product.service.ProductService;






@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	Logger logger= LoggerFactory.getLogger(ProductController.class);
	
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	@PostMapping("/add")
	public ResponseEntity<Product> addProducts(@RequestBody Product product) {
	
		
		logger.warn("product"+product);
		
		Product addedUser= service.addProduct(product);
		
		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
		
	}
	@GetMapping("/findById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {
	return new ResponseEntity<>	(service.getProductById(productId),HttpStatus.OK);
		
	}

	@GetMapping("/findByType/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String productType) {
		
		return new ResponseEntity<>(service.getProductByType(productType),HttpStatus.OK);
	}

	@GetMapping("/findByName/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		
		return service.getProductByName(productName);
	}

	@GetMapping("/findByCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
		
		return new ResponseEntity<>(service.getProductByCategory(category),HttpStatus.OK);
	}

	@PutMapping("/update/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product) throws ProductNotFoundException {
		;
		return  ResponseEntity.ok(service.updateProducts(productId,product));
	}

	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable int productId)throws ProductNotFoundException {
		
		return service.deleteProductById(productId);
	}
	
}
