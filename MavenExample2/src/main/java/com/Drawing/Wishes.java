package com.Drawing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Wishes {

	public static void main(String[] args) {
	
           AbstractApplicationContext context=new ClassPathXmlApplicationContext("wish.xml");
            context.registerShutdownHook();
            Greetings greeting=(Greetings) context.getBean("greeting");
             greeting.greetings();
	}

}
