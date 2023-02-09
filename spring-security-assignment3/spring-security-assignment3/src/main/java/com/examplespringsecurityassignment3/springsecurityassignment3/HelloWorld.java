package com.examplespringsecurityassignment3.springsecurityassignment3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
  
	@GetMapping("/")
	  public String sayHello()
	  {
		  return "Hello World";
	  }
	  @GetMapping("/user")
	  public String getUser()
	  {
		  return "Hello User";
	  }
	  @GetMapping("/admin")
	  public String getAdmin()
	  {
		  return "Hello Admin";
	  }
}
