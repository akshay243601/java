package com.akshay.Multithreading;

class Runner extends Thread {
	static int counter = 0;

	public synchronized void printOdd() {
		while (true) {
			if (counter % 2 != 0) {
				System.out.println(counter);
				counter++;
			}
		}
	}

	public synchronized void printEven() {
		while (true) {
			if (counter % 2 == 0) {
				System.out.println(counter);
				counter++;
			}
		}
	}
	
	
}

public class TwoThreadPrintSequentialIntByUsingTwoThread {

	public static void main(String[] args) {
		Runner thread1 = new Runner() {
			@Override
			public void run() {
				printOdd();
			}
		};
		Runner thread2 = new Runner() {
			@Override
			public void run() {
				printEven();
			}
		};

		thread1.start();
		thread2.start();

	}
}
