package com.akshay.coreBasics;

class A11 {
	String ss;
	public A11(String a) {
		ss = a;
	}

}

class B11 extends A11 {
	String pp;

	public B11(String b) {
		super(b);   //if this is mnot used then it will give you compile time error
		pp = b;
	}

}

public class BasicMain2 {

	static int[] x, y;

	public static void main(String[] args) {
		x = new int[2];
		x = y;
		System.out.println(x);

		final int x;
		x = 20;
		System.out.println(20);
		
		

	}
}
