package com.akshay.practice.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Message {
	private String msg;

	public Message(String message) {
		this.msg = message;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}
}

class Producer implements Runnable {

	BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Message m = new Message("" + i);
				queue.put(m);
				System.out.println("Produce Message .. " + m.getMsg());
			}
			queue.put(new Message("exit"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			Message msg = null;
			while(!(msg = queue.take()).getMsg().equalsIgnoreCase("exit")){
				Thread.sleep(1000);
				System.out.println("Consumed Message .. " + msg.getMsg());
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>(1);
		Thread producer =  new Thread(new Producer(queue));
	//	Thread consumer1 =  new Thread(new Consumer(queue));
		//Thread consumer2 =  new Thread(new Consumer(queue));
		 producer.start();
		// consumer1.start();
		//consumer2.start();
		
		
	}

}
