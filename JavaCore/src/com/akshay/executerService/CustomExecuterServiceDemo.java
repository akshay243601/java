package com.akshay.executerService;

//https://caffinc.github.io/2016/03/simple-threadpool/

import com.akshay.executerService.SimpleThreadPool.SimpleThreadPoolThread;

class MyThread implements Runnable {
	String name;
	MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Thread" + name + 
				" is runing");
		try {
			Thread.sleep(100l);
		}
		catch (Exception e) {
			// TODO: handle exception
		} 
		System.out.println("Thread " + name + " is completed.......");
		
	}
	
}

public class CustomExecuterServiceDemo {

	public static void main(String[] args) throws Exception {
		SimpleThreadPool threadPool = new SimpleThreadPool(2);
		for(int i = 0; i < 100; i++) {
			MyThread obj = new MyThread("" + i);
			threadPool.execute(obj);
		
			if(i == 6) {
				threadPool.shutdown();
			}
			
			if(i == 9) {
				threadPool.terminate();
			}
		}
		
	}

}
