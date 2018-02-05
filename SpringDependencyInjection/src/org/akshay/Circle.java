package org.akshay;

public class Circle implements Shape{

	private Point centerPoint;

	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	@Override
	public void drawShape() {
		System.out.println("Circle Draw Method is called");
		System.out.println("point are as :- " + getCenterPoint().getX() + "  " + getCenterPoint().getY());
	}
}
