package com.akshay.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Message {
	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

class Producer implements Runnable {

	BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Message m = new Message("" + i);
				queue.put(m);
				System.out.println("Produced : " + m.getMessage());
				// Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		try {// Adding exit message
			Message m = new Message("exit");
			queue.put(m);
			System.out.println("Produced : Exit");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Consumer implements Runnable {

	BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		Message msg = null;
		try {
			while ((msg = queue.take()).getMessage() != "exit") {
				Thread.sleep(200);
				System.out.println("Consumed :" + msg.getMessage());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>(3);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
