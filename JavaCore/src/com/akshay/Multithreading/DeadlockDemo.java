package com.akshay.Multithreading;

public class DeadlockDemo {

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void m1() {
		System.out.println("m1 enter");
		synchronized (lock1) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("m1 : lock1 inside");
			synchronized (lock2) {
				System.out.println("m1 : lock2 inside");
			}
		}
		System.out.println("m1 exit");

	}

	public void m2() {
		System.out.println("m2 enter");
		synchronized (lock2) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("m2 : lock2 inside");
			synchronized (lock1) {
				System.out.println("m2 : lock1 inside");
			}
		}
		
		System.out.println("m2 exit");
		
	}

	public static void main(String[] args) {
		final DeadlockDemo obj1 = new DeadlockDemo();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj1.m1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj1.m2();
			}
		});
		t1.start();
		t2.start();
		
	}

}
