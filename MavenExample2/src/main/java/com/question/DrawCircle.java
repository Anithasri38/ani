package com.question;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawCircle {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("circle.xml");
		Circle circle=(Circle) context.getBean("circle");
		circle.display();
	}

}
