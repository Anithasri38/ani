package com.Drawing;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

public class Greetings implements InitializingBean,DisposableBean{
	private String greet;
	
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public void greetings ()
	{
		System.out.println("Hvae a nice day "+this.greet);
	}
	public void afterPropertiesSet()throws Exception
	{
		System.out.println("InitializingBean init method for greeting");
	}
	public void destroy()throws Exception
	{
		System.out.println("DisposableBean method called for greeting");
	}
	public void myInit()
	{
		System.out.println("IntialiZation init method for greeting");
		
	}
	public void cleanUp()
	{
		System.out.println("Destroy method for greeting");
	}

}
