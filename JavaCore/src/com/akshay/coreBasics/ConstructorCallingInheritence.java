package com.akshay.coreBasics;

class Parent_Class {
	public Parent_Class() {
		System.out.println("public Parent_Class()   is called");
		this.i = i;
	}

	int i;

}

public class ConstructorCallingInheritence extends Parent_Class {

	public ConstructorCallingInheritence(int i) {
		System.out.println("public ConstructorCallingInheritence(int i) {   is called");
	}
	
	
	public static void main(String args[]){
		System.out.println("main is running");
		
		ConstructorCallingInheritence c = new ConstructorCallingInheritence(3);
	}

}
