package com.akshay.Multithreading;

import java.util.Scanner;

class Runnable1 implements Runnable {

	public String name;

	public Runnable1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++)
			System.out.println(name + " : " + i);
	}
}

class Runnable2 implements Runnable {

	public String name;

	public Runnable2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++)
			System.out.println(name + " : " + i);
	}

}

class Runnable3 implements Runnable {

	public String name;

	public Runnable3(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++)
			System.out.println(name + " : " + i);
	}

}

public class MultiRunnableDemo {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the class which u want to run");
		int i = sc.nextInt();

	
		Runnable obj = null;
		if (i == 1) {
			obj = new Runnable1("Thread 1");
		}
		if (i == 2) {
			obj = new Runnable2("Thread 2");
		}
		if (i == 3) {
			obj = new Runnable3("Thread 3");
		}
		
		Thread thread = new Thread(obj);
		thread.start();
	}
}
