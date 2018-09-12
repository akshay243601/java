package com.akshay.Multithreading;

import java.util.LinkedList;

class ProducerConsumer {
	LinkedList<Integer> list = new LinkedList<>();

	public ProducerConsumer(LinkedList<Integer> list) {
		this.list = list;
	}

	public void produce() {

		int value = 0;
		while (true) {
			synchronized (this) {
				while (list.size() == ProducerConsumerByWaitNotifyDemo.MAX_Capacity) {
					try {
						System.out.println("Producer need to wait Because Queue is FULL");
						wait();
					} catch (Exception e) {
					}
				}

				list.add(value++);
				System.out.println("Produced value is  : " + value);
				notify();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
			}
		}
	}

	public void consume() {
		while (true) {
			synchronized (this) {
				while (list.size() == 0) {
					try {
						System.out.println("Consumer need to wait Because Queue is EMPTY");
						wait();
					} catch (Exception e) {
					}
				}
				int value = list.removeFirst();
				System.out.println("Consumed value is  : " + value);
				notify();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
			}
		}
	}
}

public class ProducerConsumerByWaitNotifyDemo {
	static int MAX_Capacity = 4;

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		ProducerConsumer pc = new ProducerConsumer(list);

		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				pc.produce();
			}
		});

		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				pc.consume();
			}

		});
		
		Thread consumer1 = new Thread(new Runnable() {

			@Override
			public void run() {
				pc.consume();
			}

		});

		producer.start();
		consumer.start();
		consumer1.start();

	}

}
