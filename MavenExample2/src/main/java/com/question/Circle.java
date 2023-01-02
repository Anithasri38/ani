package com.question;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Circle implements ApplicationContextAware{
    private Radius radius1;
    private Radius radius2;
    private ApplicationContext context=null;
	public Radius getRadius1() {
		return radius1;
	}
	public void setRadius1(Radius radius1) {
		this.radius1 = radius1;
	}
	public Radius getRadius2() {
		return radius2;
	}
	public void setRadius2(Radius radius2) {
		this.radius2 = radius2;
	}
    public void display()
    {
    	System.out.println("Circle is Drawing of Radius1:"+getRadius1().getRadius());
    	System.out.println("Circle is Drawing of Radius2:"+getRadius2().getRadius());
	
    }
    public void setApplicationContext(ApplicationContext context)
	{
		this.context=context;
		System.out.println(context);
	}
}
