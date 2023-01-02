package com.question;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListQuestion {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("question.xml");
		Question q=(Question) context.getBean("questions");
		q.displayList();
		q.displaySet();
		q.displayMap();
		
	}

}
