package com.akshay.Multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenterantReadWriteLockDemo {

	static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	public static void main(String[] args) {
		reentrantReadWriteLock.readLock().unlock();
		reentrantReadWriteLock.writeLock().lock();


	}

}
