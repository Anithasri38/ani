package com.example.shoppingcart.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.product.exception.CategoryNotFoundException;
import com.example.shoppingcart.product.exception.ProductAlreadyExistsException;
import com.example.shoppingcart.product.exception.ProductNotFoundException;
import com.example.shoppingcart.product.exception.ProductTypeNotExistsException;
import com.example.shoppingcart.product.models.Product;
import com.example.shoppingcart.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SequenceGeneratorService seqService;
	@Override
	public Product addProduct(Product product) throws ProductAlreadyExistsException{
		if(productRepository.existsById(product.getProductId())) {
			
			throw new ProductAlreadyExistsException("ProductId already exits:"+product.getProductId());
		}
			
		product.setProductId(seqService.getSequenceNum(Product.sequenceName));
		
		return productRepository.save(product);
	}
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(int productId) throws ProductNotFoundException{
		
		logger.info("Get Product By Id is started");
		Optional<Product> getProductById = productRepository.findById(productId);
		if (getProductById.isPresent()) {
			logger.info("If condition of get product by is started");
			logger.debug("Details of product by id :{}", getProductById);
			return getProductById.get();
		} else {
			logger.info("If else condition of get product by is Executed");
			return getProductById.orElseThrow(() -> new ProductNotFoundException(productId + "Product is not found"));
		}
		
	}

	//get product by product Name
	@Override
	public List<Product> getProductByName(String productName) throws ProductNotFoundException {
		
		if(productRepository.findByProductName(productName).isEmpty()) {
			logger.error("product not found  in find by produt name");
			throw new ProductNotFoundException("ProductName:"+productName+" not found");
		}
		else {
			return productRepository.findByProductName(productName);
		}
		
	}
	// update existing  product by its produtId
	@Override
	public Product updateProducts(int productId,Product product) throws ProductNotFoundException {
		
		Product	updatedProduct=productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());
		
		updatedProduct.setCategory(product.getCategory());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setImage(product.getImage());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setProductId(product.getProductId());
		updatedProduct.setProductName(product.getProductName());
		updatedProduct.setProductType(product.getProductType());
		updatedProduct.setRating(product.getRating());
		updatedProduct.setReview(product.getReview());
		updatedProduct.setSpecification(product.getSpecification());
		
		return productRepository.save(updatedProduct);
	}
	
	//delete product by productId
	@Override
	public String deleteProductById(int productId) throws ProductNotFoundException {
		logger.info("Delete Product method is started");
		Optional<Product> delete = productRepository.findById(productId);
		if (delete.isPresent()) {
			logger.info("If condition for delete product id started");
			productRepository.deleteById(productId);
			return "Deleted successfully";
		} else {
			logger.info("If else condition of delete product is executed");
			throw new ProductNotFoundException("Product doesn't Exists");
		}

	}
	
	//get all products by category
	@Override
	public List<Product> getProductByCategory(String category)  throws CategoryNotFoundException{

		List<Product> product;
		if(productRepository.findByCategory(category).isEmpty()) {
			throw new CategoryNotFoundException();
		}
		else {
			product=productRepository.findByCategory(category);
		}
		
		return product;
	}
	
	
	//get all product by productType
	@Override
	public List<Product> getProductByType(String productType) throws ProductTypeNotExistsException {
		List<Product> product;
		if(productRepository.findByProductType(productType).isEmpty()) {
			throw new ProductTypeNotExistsException();
		}
		else {
			product=productRepository.findByProductType(productType);
		}
		
		return product;
	}

	
}
