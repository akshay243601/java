package com.akshay.Multithreading;

class PrintEvenOddTester{
	public static volatile boolean isOdd = false;
	int COUNT = 0;
	int MAX_COUNT = 50;
	Object lock = new Object();
	public void printEven() {
		synchronized (this) {
			while (COUNT < MAX_COUNT) {
				
				System.out.println(this + " : " + this.getClass() );
				while (isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("EVEN "+ " :  Print : " + COUNT);
				COUNT++;
				isOdd = true;
				notify();
			}
		}
	}

	public void printOdd() {

		synchronized (this) {
			while (COUNT < MAX_COUNT) {
				
				System.out.println(this + " : " + this.getClass() );

				while (!isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("ODD " + " :  Print : " + COUNT);
				COUNT++;
				isOdd = false;
				notify();
			}
		}
	}

}

public class TwoThreadPrintSequentialNumber {

	public static void main(String[] args) {
		
		PrintEvenOddTester obj = new PrintEvenOddTester();

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.printEven();
			}
		});
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.printOdd();			}
		});

		th1.start();
		th2.start();

	}

}
