package org.akshay;

public class Triangle implements Shape{

	private Point pointA;
	private Point pointB;
	
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
	
	@Override
	public void drawShape() {
		System.out.println("Triangle Draw Method is called");
		System.out.println("point are as :- " + getPointA().getX() + "  " + getPointA().getY());
		System.out.println("point are as :- " + getPointB().getX() + "  " + getPointB().getY());
	}

}
