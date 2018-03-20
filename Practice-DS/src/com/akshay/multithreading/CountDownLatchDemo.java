package com.akshay.multithreading;

import java.util.concurrent.CountDownLatch;

class CountDownService implements Runnable{
	
	CountDownLatch latch;
	String name;
	public CountDownService(CountDownLatch latch, String name){
		this.latch = latch;
		this.name = name;
	}
	@Override
	public void run() {
		try{
			System.out.println(this.name + "  is running...");
			//Thread.sleep(1000);
		} catch (Exception e){
			System.out.println(e);
		}
		System.out.println(this.name + "  is Complete...");
		System.out.println(this.name + " Before   :   count : " + latch.getCount());
		latch.countDown();
		
		System.out.println(this.name + " After   :   count : " + latch.getCount());
		
		
	}
	
	
	
	
}


public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		Thread service1 = new Thread(new CountDownService(latch, "service 1"));
		Thread service2 = new Thread(new CountDownService(latch, "service 2"));
		Thread service3 = new Thread(new CountDownService(latch, "service 3"));
		Thread service4 = new Thread(new CountDownService(latch, "service 4"));
		Thread service5 = new Thread(new CountDownService(latch, "service 5"));
		Thread service6 = new Thread(new CountDownService(latch, "service 6"));
		
		service1.start();
		service2.start();
		service3.start();
		service4.start();
		service5.start();
		service6.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
