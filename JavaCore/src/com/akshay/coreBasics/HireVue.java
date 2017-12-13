package com.akshay.coreBasics;

import java.awt.Point;
import java.util.Scanner;

public class HireVue 
{
	
	public static void main(String args[])
	{
		
		
		Scanner sc  = new Scanner(System.in);
		// for adding binary number
		String binaryNumber = sc.nextLine();
		String[] binaryNumberArray = binaryNumber.split(" ");
		String num1 = binaryNumberArray[0];
		String num2 = binaryNumberArray[1];
		System.out.println(addTwoBinaryNumber(num1, num2));
		
		//for rectangle check
		String inputForRectangle = sc.nextLine();
		String[] rectangleArray = inputForRectangle.split(" ");
		 
		Point p1X1 =  new Point(Integer.parseInt(rectangleArray[0]), Integer.parseInt(rectangleArray[1]));
		
		int p1X2x =  Integer.parseInt(rectangleArray[0]) + Integer.parseInt(rectangleArray[2]);
		int p1X2y =  Integer.parseInt(rectangleArray[1]) + Integer.parseInt(rectangleArray[3]);
		Point p1X2 = new Point(p1X2x,p1X2y);
		
		Point p2X1 =  new Point(Integer.parseInt(rectangleArray[4]), Integer.parseInt(rectangleArray[5]));
		
		int p2X2x =  Integer.parseInt(rectangleArray[4]) + Integer.parseInt(rectangleArray[6]);
		int p2X2y =  Integer.parseInt(rectangleArray[5]) + Integer.parseInt(rectangleArray[7]);
		Point p2X2 = new Point(p2X2x,p2X2y);

		System.out.println(doOverlap(p1X1, p1X2, p2X1, p2X2));
		
		
	}
	
	

	public static String addTwoBinaryNumber(String num1, String num2) {
		int a = Integer.parseInt(num1, 2);
		int b = Integer.parseInt(num2, 2);
		int add = a + b;
		String binaryOutPut = Integer.toBinaryString(add);
		return binaryOutPut;
	}
	
	public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}
		if (l1.y > r2.y || l2.y > r1.y) {
			return false;
		}
		return true;
	}
}
