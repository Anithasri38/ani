package com.Drawing;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Line implements ApplicationContextAware,BeanNameAware{
       private Point pointA;
       private Point pointB;
       private Point pointC;
       private ApplicationContext context=null;
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	public void setApplicationContext(ApplicationContext context)
	{
		this.context=context;
		System.out.println(context);
	}
	public void setBeanName(String beanName)
	{
		System.out.println("Bean name="+beanName);
	}
       
      public void draw()
      {
    	  System.out.println("PointA=(" +getPointA().getX() +","+getPointA().getY() +")");
    	  System.out.println("PointB=(" +getPointB().getX() +","+getPointB().getY() +")");
    	  System.out.println("PointC=(" +getPointC().getX() +","+getPointC().getY() +")");
      }
}

