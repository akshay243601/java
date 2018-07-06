package com.akshay.synchronizationDemo;

public class Employee {

	Object lock1 = new Object();
	Object lock2 = new Object();
	static int counter = 0;

	// Case 1 with lock on diff. method with diff. lock [lock1 and lock2]
	public synchronized void printOdd(String name) {
	//	synchronized (lock1) 
		{
			while (true) {
				if (counter % 2 != 0) {
					System.out.println("Thread " + name + "  " + counter);
					counter++;
				}
			}
		}
	}

	public void printEven(String name) {
	//	synchronized (lock2)
		{
			while (true) {
				if (counter % 2 == 0) {
					System.out.println("Thread " + name + "  " + counter);
					counter++;
				}
			}
		}
	}

}
