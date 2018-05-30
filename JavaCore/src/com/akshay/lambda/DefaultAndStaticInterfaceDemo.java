package com.akshay.lambda;

public class DefaultAndStaticInterfaceDemo
		implements InterfaceWithDefaultAndStaticMethod, InterfaceWithDefaultAndStaticMethod1 {

	@Override
	public void defaultMethod() {
		// TODO Auto-generated method stub
		InterfaceWithDefaultAndStaticMethod.super.defaultMethod();
		InterfaceWithDefaultAndStaticMethod1.super.defaultMethod();
	}

	public void printDemo(String name) {
		System.out.println(name);
	}

	public DefaultAndStaticInterfaceDemo() {
		super();
	}

	public static void main(String args[]) {
		DefaultAndStaticInterfaceDemo obj = new DefaultAndStaticInterfaceDemo();
		obj.printDemo("Akshay");
		obj.defaultMethod();
		
		InterfaceWithDefaultAndStaticMethod.staticMethod();
		InterfaceWithDefaultAndStaticMethod1.staticMethod();

	}

}

@FunctionalInterface
interface InterfaceWithDefaultAndStaticMethod {
	void printDemo(String name);

	default void defaultMethod() {
		System.out.println("InterfaceWithDefaultAndStaticMethod : defaultMethod");
	}
	
	default void defaultMethod1() {
		System.out.println("InterfaceWithDefaultAndStaticMethod : defaultMethod1");
	}

	static void staticMethod() {
		System.out.println("InterfaceWithDefaultAndStaticMethod : staticMethod");
	}
	
	static void staticMethod1() {
		System.out.println("InterfaceWithDefaultAndStaticMethod : staticMethod1");
	}

}

@FunctionalInterface
interface InterfaceWithDefaultAndStaticMethod1 {
	void printDemo(String name);

	default void defaultMethod() {
		System.out.println("InterfaceWithDefaultAndStaticMethod1 : defaultMethod");
	}
	static void staticMethod() {
		System.out.println("InterfaceWithDefaultAndStaticMethod1 : staticMethod");
	}
}