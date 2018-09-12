package com.akshay.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/*Best Reference
 *  http://www.baeldung.com/java-runnable-callable
 * 
 * 
 * 
 * 
 * 
 */

class MyThread extends Thread {

	public void run() {
		System.out.println("Thread is running..");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
}

// By using callable we can get response while in runnable we can not get
// response as Runnable/Thread's run method have void retun type
// By using callable we can get response because its call method have response
// type
class MyCallable implements Callable<String> { // here we are defining call
												// method will return String
												// type response

	String name;

	public MyCallable(String name) {
		this.name = name;
	}

	// it is returning String because we used [Callable< "String" >]
	@Override
	public String call() throws Exception {
		System.out.println("MyCallable call() is running..");
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		return this.name;
	}

}

public class CallableDemo {

	private static void testExecutorServiceUsingCallable()
			throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService ex = Executors.newFixedThreadPool(3);
		List<Future<String>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MyCallable m = new MyCallable("Callable-" + i);
			results.add(ex.submit(m));
		}

		System.out.println("Before Shutdown");
		ex.shutdown();

		ListIterator<Future<String>> listIterator = results.listIterator();
		while (listIterator.hasNext()) {
			// String result = listIterator.next().get(1,TimeUnit.MILLISECONDS); //it will thorw because in 1 MS thread is not completed
			Future<String> futureResult = listIterator.next();
			
			if (futureResult.isCancelled()) {
				try{
				System.out.println("Cancalled : " + futureResult.get());
				} catch (Exception e){
					System.out.println(e.getCause());
				}
			} else if (futureResult.isDone()) {
				String result = futureResult.get();
				System.out.println("Done : " + result);
				System.out.println(result);
			}
			
			if(listIterator.nextIndex() == 4){
				futureResult.cancel(true);
			}
		}
		
				

		System.out.println("After Shutdown");
		
		
		listIterator = results.listIterator();
		while (listIterator.hasNext()) {
			// String result = listIterator.next().get(1,TimeUnit.MILLISECONDS); //it will thorw because in 1 MS thread is not completed
			Future<String> futureResult = listIterator.next();

			if (futureResult.isCancelled()) {
				System.out.println("Cancalled task ");
			} else if (futureResult.isDone()) {
				String result = futureResult.get();
				System.out.println("Done : " + result);
				System.out.println(result);
			}

		}
		
		
		while (!ex.isTerminated()) {
		
		}
		
		
		
		listIterator = results.listIterator();
		while (listIterator.hasNext()) {
			// String result = listIterator.next().get(1,TimeUnit.MILLISECONDS); //it will thorw because in 1 MS thread is not completed
			Future<String> futureResult = listIterator.next();

			if (futureResult.isCancelled()) {
				System.out.println("Cancalled task ");
			} else if (futureResult.isDone()) {
				String result = futureResult.get();
				System.out.println("Done : " + result);
				System.out.println(result);
			}

		}
		

		System.out.println("Completed....");

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		//testExecutorServiceUsingThread();

		testExecutorServiceUsingCallable();

	}

	private static void testExecutorServiceUsingThread() {
		ExecutorService ex = Executors.newFixedThreadPool(3);
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();

		ex.submit(t1);
		ex.submit(t2);
		ex.submit(t3);
		ex.submit(t4);

		System.out.println("Before Shut Down");
		ex.shutdown();

		System.out.println("After Shut Down");
		while (!ex.isTerminated()) {

		}
		System.out.println("All are completed.....");
	}

}
