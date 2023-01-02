package com.Drawing;

import org.springframework.beans.factory.BeanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {
    
	public static void main(String[] args) {
		
      //Triangle triangle=new Triangle();
		//BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
         // triangle.draw();
          ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
         Triangle triangle=(Triangle) context.getBean("tri");
         triangle.draw();
         // ApplicationContext context=new ClassPathXmlApplicationContext("objects.xml");
          //Line line=(Line) context.getBean("line-name");
          //line.draw();
         // ApplicationContext context=new ClassPathXmlApplicationContext("inheritance.xml");
          // Line line=(Line) context.getBean("line2");
           // line.draw();
          // ApplicationContext context=new ClassPathXmlApplicationContext("list.xml");
           //LineSegment linesegment=(LineSegment) context.getBean("linesegment");
           //linesegment.Listdetails();
		 
	}

}
