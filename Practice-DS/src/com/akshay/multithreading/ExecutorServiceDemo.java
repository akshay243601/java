package com.akshay.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {

	public String name;

	WorkerThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(name + " is calling");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " is Complete");
	}

}

public class ExecutorServiceDemo {

	public static void main(String[] args) {
	
		ExecutorService  executorService = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10 ; i++){
			WorkerThread workerThread = new WorkerThread("Thread " + i);
			executorService.execute(workerThread);
		}
		
		executorService.shutdown();
		
		while(!executorService.isTerminated()){
		//	System.out.println("It is running...");
		}
	
		System.out.println("Finished");
	}

}
