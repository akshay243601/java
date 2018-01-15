package com.akshay.Multithreading;

public class RunnableDemo implements Runnable {

	private String name;

	public RunnableDemo(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0 ; i <= 5 ; i++)
			System.out.println(this.getName() + " : " + i);
	}

	public static void main(String args[]) {
		System.out.println("Start");
		
		Thread obj = new Thread(new RunnableDemo("Thread 1"));
		obj.start();

		Thread obj1 = new Thread(new RunnableDemo("Thread 2"));
		obj1.start();

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
