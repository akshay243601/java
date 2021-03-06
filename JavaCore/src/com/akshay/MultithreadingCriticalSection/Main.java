package com.akshay.MultithreadingCriticalSection;

public class Main {
	public static void main(String args[]) {
		CustomSemaphore semaphore = new CustomSemaphore(3);
		for (int i = 0; i < 10; i++) {
			(new MutualExclusionClass(semaphore, "Thread " + i)).start();
		}
	}
}
