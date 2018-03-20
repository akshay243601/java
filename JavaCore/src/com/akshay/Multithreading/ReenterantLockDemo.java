/**
 * 
 */
package com.akshay.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author akshay.gupta
 *
 */
public class ReenterantLockDemo extends Thread {

	static int count = 0;
	static final Lock lock = new ReentrantLock();

	private static void increaseCount() {
		count++;
	}

	private static void firstCounter() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			increaseCount();
		}
		lock.unlock();
	}

	private static void secondCounter() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			increaseCount();
		}
		lock.unlock();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new ReenterantLockDemo()) {
			@Override
			public void run() {
				firstCounter();
			}
		};
		Thread t2 = new Thread(new ReenterantLockDemo()) {
			@Override
			public void run() {
				secondCounter();
			}
		};

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(count);
		}
	}

}
