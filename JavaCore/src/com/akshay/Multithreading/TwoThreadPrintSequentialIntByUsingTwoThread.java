package com.akshay.Multithreading;

class Runner extends Thread {
	static int counter = 0;

	Object lock1 = new Object();
	Object lock2 = new Object();

	
	//Case 1 with lock on diff. method with diff. lock [lock1 and lock2]
	public void printOdd() {
		synchronized (lock1) 
		{
			while (true) {
				if (counter % 2 != 0) {
					System.out.println("Thread " + this.getName() + "  "  + counter);
					counter++;
				}
			}
		}
	}

	public void printEven() {
		synchronized (lock2) 
		{
			while (true) {
				if (counter % 2 == 0) {
					System.out.println("Thread " + this.getName()  + "  " + counter);
					counter++;
				}
			}
		}
	}
	
	
	//Case 2 with lock on diff. method with same lock [lock1]
	/*public void printOdd() {
		synchronized (lock1) 
		{
			while (true) {
				if (counter % 2 != 0) {
					System.out.println(counter);
					counter++;
				}
			}
		}
	}

	public void printEven() {
		synchronized (lock1) 
		{
			while (true) {
				if (counter % 2 == 0) {
					System.out.println(counter);
					counter++;
				}
			}
		}
	}*/
	
	
	//Case 3 with lock on diff. method with static
	/*public void printOdd() {
		synchronized (lock1) 
		{
			while (true) {
				if (counter % 2 != 0) {
					System.out.println(counter);
					counter++;
				}
			}
		}
	}

	public void printEven() {
		synchronized (lock2) 
		{
			while (true) {
				if (counter % 2 == 0) {
					System.out.println(counter);
					counter++;
				}
			}
		}
	}*/
	
}

public class TwoThreadPrintSequentialIntByUsingTwoThread {

	public static void main(String[] args) {
		System.out.println("started...");

		Runner thread1 = new Runner() {
			@Override
			public void run() {
				printOdd();
			}
		};
		
		thread1.setName("thread1");
		Runner thread2 = new Runner() {
			@Override
			public void run() {
				printOdd();
			}
		};
		thread2.setName("thread2");

		thread1.start();
		thread2.start();
	}
}
