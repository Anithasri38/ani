package com.Drawing;

public class Triangle{
	private String type;
	private int side;
	public Triangle(int side)
	{
		this.side=side;
	}
	public Triangle(int side,String type)
	{
		this.side=side;
		this.type=type;
	}
	
	public int getSide() {
		return side;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw()
	{
		System.out.println(getType()+" Traingle Drawing of side "+this.side+"cm");
	}
	/*public void afterPropertiesSet()throws Exception
	{
		System.out.println("IntializingBean");
	}
	public void destroy()throws Exception
	{
		System.out.println("DestroyBean");
	}*/
	/*public void myInIt()
	{
		System.out.println("IntializingBean");
	}
	public void cleanUp()
	{
		System.out.println("DestroyBean");
	}*/

}
