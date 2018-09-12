package com.akshay.Multithreading;

import java.util.LinkedList;
import java.util.Queue;

class ProducerWorker implements Runnable {
	Queue<Integer> queue;
	public int maxSize;

	public ProducerWorker(int maxSize, Queue<Integer> shareqQueue) {
		this.queue = shareqQueue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		int value = 0;
		while (true) {
			synchronized (queue) {
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full So waiting....");
						queue.wait();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				this.queue.add(value++);
				System.out.println("Produced Value is : " + value);
				queue.notify();
				try{
					Thread.sleep(1000);
				} catch(Exception e){
				}
			}
		}

	}
}

class ConsumerWorker implements Runnable {
	Queue<Integer> queue;
	public int maxSize;

	public ConsumerWorker(int maxSize, Queue<Integer> shareqQueue) {
		this.queue = shareqQueue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is Empty So waiting....");
						queue.wait();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				int value = queue.remove();
				System.out.println("Consumed Value is : " + value);
				queue.notify();
				try{
					Thread.sleep(1000);
				} catch(Exception e){
				}

			}
		}

	}
}

public class ProducerConsumerByUsingDiffernceClassAndUsingWaitNotifyDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();

		Thread producer = new Thread(new ProducerWorker(4, queue));
		Thread consumer = new Thread(new ConsumerWorker(4, queue));
		producer.start();
		consumer.start();
	}

}
