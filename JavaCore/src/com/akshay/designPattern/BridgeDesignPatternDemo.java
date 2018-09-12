/*
 *  When we have interface hierarchies in both interfaces as well as implementations, 
 *  then bridge design pattern is used to decouple the interfaces from implementation 
 *  and hiding the implementation details from the client programs.
 * 
 * According to GoF bridge design pattern is:
 * It is Structural design pattern
 * Decouple an abstraction from its implementation so that the two can vary independently
 */

package com.akshay.designPattern;

interface Color {
	public void applyColor();
}

abstract class Shape {
	public Color color;
	public abstract void printShape();
}

class Triangle extends Shape {
	public Triangle(Color color) {
		this.color = color;
	}

	@Override
	public void printShape() {
		System.out.print("This is thriangle with color : ");
		this.color.applyColor();
	}
}

class Pentagon extends Shape {
	public Pentagon(Color color) {
		this.color = color;
	}

	@Override
	public void printShape() {
		System.out.print("This is Pentagon with color : ");
		this.color.applyColor();
	}
}

class RedColor implements Color {

	@Override
	public void applyColor() {
		System.out.println("Red");
	}

}

class GreenColor implements Color {

	@Override
	public void applyColor() {
		System.out.println("Green");
	}

}

public class BridgeDesignPatternDemo {

	public static void main(String[] args) {
		Shape triangle = new Triangle(new RedColor());
		Shape pentagon = new Pentagon(new GreenColor());
		triangle.printShape();
		pentagon.printShape();
	}

}
