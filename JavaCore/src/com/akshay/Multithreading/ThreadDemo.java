package com.akshay.Multithreading;

public class ThreadDemo extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++)
			System.out.println(this.getName() + " : " + i);
	}

	public static void main(String args[]) {
		System.out.println("Start");
		ThreadDemo obj = null;
		ThreadDemo obj1 = null;
		ThreadDemo obj2 = null;

		obj = new ThreadDemo();
		obj.setName("Thread 1");
		obj.start();

		obj1 = new ThreadDemo();
		obj1.setName("Thread 2");
		obj1.start();

		obj2 = new ThreadDemo();
		obj2.setName("Thread 3");
		obj2.start();

		/*
		 * ThreadDemo obj2 = new ThreadDemo(); obj2.setName("Thread 3");
		 * obj2.start();
		 * 
		 * 
		 * ThreadDemo obj3 = new ThreadDemo(); obj3.setName("Thread 4.");
		 * obj3.start();
		 */

		System.out.println("End");
	}
}
