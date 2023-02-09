package com.examplespringsecurityassignment2.springsecurityassignment2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorld {

	  @RequestMapping(value="/login",method=RequestMethod.GET)
	  public String loginPage()
	  {
		  return "login";
	  }
	  @RequestMapping(value="/admin",method=RequestMethod.POST)
	  public String sayadmin()
	  {
		  return "hello admin";
	  }
}
