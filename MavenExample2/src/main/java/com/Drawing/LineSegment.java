package com.Drawing;

import java.util.List;

public class LineSegment {
	private List<Point> point;

	public List<Point> getPoint() {
		return point;
	}

	public void setPoint(List<Point> point) {
		this.point = point;
	}
	public void Listdetails()
	{
		for(Point point:point)
		{
			System.out.println("Point=(" +point.getX() +","+point.getY()+")");
		}
	}
}
