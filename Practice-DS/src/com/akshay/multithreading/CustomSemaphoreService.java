package com.akshay.multithreading;

class CustomSemaphore {

	int value;

	public CustomSemaphore(int value) {
		this.value = value;
	}

	public synchronized void down() {
		try {
			while (value == 0) {
				wait();
			}
		} catch (Exception e) {
			// System.out.println(e);
		}
		value--;
	}

	public synchronized void up() {
		value++;
		notify();
	}
}

class MutualExclusion extends Thread {
	CustomSemaphore semaphore;

	public MutualExclusion(String name, CustomSemaphore semaphore) {
		this.setName(name);
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		while (true) {
			this.semaphore.down();
			System.out.println(this.getName() + " service is down");
			try {

				Thread.sleep((int) (Math.random() * 100));

			} catch (Exception e) {

			}
			this.semaphore.up();
			System.out.println(this.getName() + " service is up");

		}
	}
}

public class CustomSemaphoreService {

	public static void main(String[] args) {
		CustomSemaphore semaphore = new CustomSemaphore(3);
		for (int i = 0; i < 10; i++) {
			new MutualExclusion("Thread  " + i, semaphore).start();
		}
	}

}
