package com.question;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Maintain {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("anno.xml");
		Customer customer=(Customer) context.getBean("Customer");
		customer.customerDetails();

	}

}
