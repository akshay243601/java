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

		Thread thread = null;
		if (i == 1) {
			Runnable1 obj = new Runnable1("Thread 1");
			thread = new Thread(obj);
		}
		if (i == 2) {
			thread = new Thread(new Runnable2("Thread 2"));
		}
		if (i == 3) {
			thread = new Thread(new Runnable3("Thread 3"));
		}
		thread.start();
	}
}
