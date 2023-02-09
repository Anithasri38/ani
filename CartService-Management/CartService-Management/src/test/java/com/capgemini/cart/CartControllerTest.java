package com.capgemini.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.cart.controller.CartController;
import com.capgemini.cart.exception.CartNotFoundException;
import com.capgemini.cart.models.Cart;
import com.capgemini.cart.models.ErrorResponse;
import com.capgemini.cart.models.Items;
import com.capgemini.cart.models.LoggerResponse;
import com.capgemini.cart.repository.CartRepository;
import com.capgemini.cart.service.CartService;



@SpringBootTest
public class CartControllerTest {

	@Mock
	  private CartService cartService;
	  @InjectMocks
	  private CartController cartController;
	  List<Cart> carts;
	  Cart cart;
	  List<Items> items;
	  
	  @Test
	  public void getAllCartsTest()
	  {
		  items=new ArrayList<Items>();
		  carts=new ArrayList<Cart>();
		  items.add(new Items(1,"killer",200,1,""));
		  carts.add(new Cart(1,items,200));
		  carts.add(new Cart(2,items,200));
		  when(cartService.getAllCarts()).thenReturn(carts);
		 ResponseEntity<List<Cart>> result=cartController.getAllCarts();
		  assertEquals(2,result.getBody().size());
	  }
	  
	  @Test
	  public void getCArtByIdTest()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart(1,items,200);
		  int id=1;;
			when(cartService.getCartById(id)).thenReturn(cart);
			ResponseEntity<Cart> result=cartController.getCartById(id);
			assertEquals(id,result.getBody().getCartId());

	  }
	  @Test
	  public void updateCartTest()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart(1,items,200);
		  int id=1;;
			when(cartService.getCartById(id)).thenReturn(cart);
			when(cartService.updateCart(id, cart)).thenReturn(cart);
			//ResponseEntity<Cart> result=cartController.updateCart(id, cart);
			//assertEquals(id,result.getBody().getCartId());
	  }
	  @Test
	  public void CartTotalTest()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart(1,items,200);
		  int id=1;
		  double total=cartService.cartTotal(cart);
		  //ResponseEntity<Double> result=cartController.getTotal(0)
		  assertEquals(total,cartController.getTotal(id));
	  }
	  @Test
	  public void deleteCart()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart(1,items,200);
		  int id=1;
		  cartController.deleteCartById(id);
	  }
	  @Test
	  public void errorResponses_test() {

	  	ErrorResponse e1 = new ErrorResponse(HttpStatus.OK, "NOT NULL", LocalDateTime.now());
	  	e1.setMessage("NOT NULL");
	  	e1.setStatusmessage(HttpStatus.OK);
	  	e1.setDatetime(LocalDateTime.now());

	  }

	  @Test
	  public void LoggerResponse_test() {
	  	LoggerResponse l = new LoggerResponse();
	  	l.setMessage("NOT FOUND");

	  }

	  @Test
	  public void LoggerResponses_test() {
	  	LoggerResponse l = new LoggerResponse("Not Found");
	  	l.setMessage("NOt Null");
	  	l.getMessage();
	  }
	  @Test
	  public void CartConstructorTest()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart(1,items,200);
		  cart.setCartId(2);
		  cart.setItems(items);
		  cart.setTotalPrice(200);
	  }
	  @Test
	  public void CartDefaultContructor()
	  {
		  items=new ArrayList<Items>();
		  cart=new Cart();
		  cart.setCartId(1);
		  cart.setItems(items);
		  cart.setTotalPrice(200);
	  }
	
}
