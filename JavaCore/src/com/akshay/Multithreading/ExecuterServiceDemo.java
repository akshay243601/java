package com.akshay.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuterServiceDemo {

	public static void main(String args[]) {

		final ExecutorService executerService = Executors.newFixedThreadPool(2);
		Thread cacheService = new Thread(new Service1("CacheService", 1000));
		Thread alertService = new Thread(new Service1("AlertService", 1000));
		Thread validationService = new Thread(new Service1("ValidationService", 1000));

		try {
			executerService.execute(cacheService);
			executerService.execute(alertService);
			executerService.execute(validationService);
			System.out.println("Before Shutdown");
			executerService.shutdown();
			System.out.println("After Shutdown");

			while (!executerService.isTerminated()) {
			}

			System.out.println("All services are up, Application is starting now");
		} catch (Exception ie) {
			ie.printStackTrace();
		}
	}
}

class Service1 implements Runnable {
	private final String name;
	private final int timeToStart;

	public Service1(String name, int timeToStart) {
		this.name = name;
		this.timeToStart = timeToStart;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is going to start");
			Thread.sleep(timeToStart);
			System.out.println(name + " is after sleep");
		} catch (InterruptedException ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(name + " is Up");
	}

}