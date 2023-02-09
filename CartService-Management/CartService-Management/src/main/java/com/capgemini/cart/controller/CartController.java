package com.capgemini.cart.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import com.capgemini.cart.models.Cart;
import com.capgemini.cart.models.Items;
import com.capgemini.cart.models.Product;
import com.capgemini.cart.repository.CartRepository;
import com.capgemini.cart.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	  CartRepository cartRepository;
	@Autowired
	  RestTemplate restTemplate;
	 Logger logger=LoggerFactory.getLogger(CartController.class);
	
	public CartController(CartService cartService)
	{
		this.cartService=cartService;
	}
	public CartController()
	{
		
	}
	@GetMapping("/allcarts")
	public ResponseEntity<List<Cart>> getAllCarts()
	{
		return ResponseEntity.ok(cartService.getAllCarts());
	}
	@PostMapping("/addProductToCart/{cartId}/{productId}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable(value="cartId") int cartId,@PathVariable(value="productId") int productId)
	{
		Product product=restTemplate.getForObject("http://Product-Management/product/findById/"+productId,Product.class);
		if(cartRepository.existsById(cartId))
		{
			Cart oldCart=cartRepository.findById(cartId);
		    List<Integer> idList=new ArrayList<>();
		    List<Items> oldItem3=oldCart.getItems();
		    
		    for(Items i:oldItem3)
		    {
		    	idList.add(i.getProductId());
		    }
		    if(idList.contains(product.getProductId()))
		    {
		    	List<Items> oldItem2=oldCart.getItems();
		    	for(Items i:oldItem2)
		    	{
		    		if(i.getProductId()==productId)
		    		{
		    			i.setQuantity(i.getQuantity()+1);
		    		}
		    	}
		    	double price=0;
		    	for(Items i:oldItem2)
		    	{
		    		price=price+i.getPrice()*i.getQuantity();
		    	}
		    	oldCart.setTotalPrice(price);
		    return new ResponseEntity<>(cartService.addCart(oldCart),HttpStatus.CREATED);
		}
		else
		{
			Items items=new Items();
			items.setProductId(productId);
			items.setProductName(product.getProductName());
		    items.setPrice(product.getPrice());
		    items.setQuantity(1);
		    items.setImage(product.getImage());
		    List<Items> oldItems=oldCart.getItems();
		    oldItems.add(items);
		    double price=0;
		    for(Items i:oldItems)
		    {
		    	price=price+i.getPrice()*i.getQuantity();
		    }
		    oldCart.setTotalPrice(price);
		    return new ResponseEntity<>(cartService.addCart(oldCart),HttpStatus.CREATED);
		}
	}else
		{
		    Cart cart=new Cart();
		    cart.setCartId(cartId);
		    Items items=new Items();
		    items.setProductId(productId);
		    items.setProductName(product.getProductName());
		    items.setPrice(product.getPrice());
		    items.setQuantity(1);
		    items.setImage(product.getImage());
		    List<Items> list=new ArrayList<>();
		    list.add(items);
		    cart.setItems(list);
		    double price=0;
		    for(Items i:list)
		    {
		    	price=price+i.getPrice()*i.getQuantity();
		    }
		    cart.setTotalPrice(price);
		    return new ResponseEntity<>(cartRepository.save(cart),HttpStatus.CREATED);
		}
		
    }
    @GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId)
	{
		return  new ResponseEntity<>(cartService.getCartById(cartId),HttpStatus.OK);
	}
   
    @PutMapping("/delete/item/{productId}/{cartId}")
    public Cart deleteCartItem(@PathVariable int productId,@PathVariable int cartId)
    {
    	Product product=restTemplate.getForObject("http://Product-Management/product/findById/"+productId,Product.class);
    	Cart cart2=cartService.getCartById(cartId);
    	List<Items> list=new ArrayList<>();
    	list=cart2.getItems();
    	list.removeIf(i->i.getProductId()==productId);
    	cart2.setItems(list);
    	double price=0;
    	for(Items i:list)
    	{
    		price=price+i.getPrice()*i.getQuantity();
    	}
    	cart2.setTotalPrice(price);
    	return cartService.updateCart(cart2.getCartId(),cart2);
    	
    }
    @PutMapping("/increaseQuantity/{productId}/{cartId}")
    public Cart increaseItem(@PathVariable int productId,@PathVariable int cartId)
    {
    	Cart cart=cartService.getCartById(cartId);
    	List<Items> oldItem3=cart.getItems();
    	for(Items i:oldItem3)
    	{
    		if(i.getProductId()==productId)
    		{
    			i.setQuantity(i.getQuantity()+1);
    		}
    	}
    	double price=0;
    	for(Items i:oldItem3)
    	{
    		price=price+i.getPrice()*i.getQuantity();
    	}
    	cart.setTotalPrice(price);
    	return cartService.updateCart(cartId, cart);
    }
     @PutMapping("/decreaseQuantity/{productId}/{cartId}")
     public Cart decreaseItem(@PathVariable int productId,@PathVariable int cartId)
     {
    	 Cart cart=cartService.getCartById(cartId);
    	 List<Items> oldItem3=cart.getItems();
    	 for(Items i:oldItem3)
    	 {
    		 if(i.getProductId()==productId)
    		 {
    			 i.setQuantity(i.getQuantity()-1);
    		 }
    	 }
    	 double price=0;
    	 for(Items i:oldItem3)
    	 {
    		 price=price+i.getPrice()*i.getQuantity();
    	 }
    	 cart.setTotalPrice(price);
    	 return cartService.updateCart(cartId, cart);
     }
     @DeleteMapping("/delete/{cartId}")
     public void deleteCartById(@PathVariable int cartId)
     {
    	 cartService.deleteCart(cartId);
     }
     @GetMapping("/total/{cartId}")
     public double getTotal(@PathVariable int cartId)
     {
    	 Cart cart=cartService.getCartById(cartId);
    	 return cartService.cartTotal(cart);
     }
     
}

    

