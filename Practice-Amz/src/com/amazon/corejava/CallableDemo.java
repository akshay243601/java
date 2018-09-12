package com.amazon.corejava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<String> {
	String name;

	public MyCallable(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("My callable is running : " + this.name);
		try{
			Thread.sleep(1000);
		} catch(Exception e){
			
		}
		return name;
	}
}

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			MyCallable callable = new MyCallable(" Callable : " + i);
			es.submit(callable);
		}
		es.shutdown();
		while(!es.isTerminated()){}
		System.out.println("Complete");
	}

}
