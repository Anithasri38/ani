package com.example.shoppingcart.product.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.product.models.Product;


@Service
public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int productId);

	public List<Product> getProductByName(String productName);

	public Product updateProducts(int productId,Product product);

	public String deleteProductById(int productId);

	public List<Product> getProductByCategory(String category);

	public List<Product> getProductByType(String productType);
}
