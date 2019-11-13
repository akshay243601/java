package com.akshay.executerService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;



public class SimpleThreadPool {
	// Count of threadpools created
    private static AtomicInteger poolCount = new AtomicInteger(0);	
    ConcurrentLinkedQueue<Runnable> queue =null;
	AtomicBoolean active = null;
	private List<SimpleThreadPoolThread> threads = null;
	
	
	//Work for a thread
	class SimpleThreadPoolThread extends Thread {
		AtomicBoolean active;
		ConcurrentLinkedQueue<Runnable> queue;
		String name;
		public SimpleThreadPoolThread(String name, AtomicBoolean active, ConcurrentLinkedQueue<Runnable> queue) {
			this.name = name;
			this.active = active;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			while(active.get() || !this.queue.isEmpty()) {
				Runnable r = this.queue.poll();
				if(r != null) {
					System.out.println("Start : " + this.name + " is start running...");
					r.run();
					System.out.println("End : " + this.name + " is start running...");
				}
			}
		}	
	}
	
	
	public SimpleThreadPool(int threadCount) {
		this.poolCount.incrementAndGet();
	    queue = new ConcurrentLinkedQueue<Runnable>();
		active = new AtomicBoolean(true);
		threads = new LinkedList<SimpleThreadPool.SimpleThreadPoolThread>();
		for(int i = 0; i < threadCount; i++) {
			SimpleThreadPoolThread thread = new SimpleThreadPoolThread("SimpleThreadPoolThread " + i,   this.active, this.queue);
			thread.start();
			this.threads.add(thread);
			
		}
	}
	
	public void execute(Runnable runnable) throws Exception {
		if(active.get()) {
			this.queue.add(runnable);
		} else {
			throw new Exception("Can't accept new task.");
		}
		
	}
	
	public void shutdown() {
		this.active.set(Boolean.FALSE);
	}
	
	public void terminate() {
		this.queue.clear();
		this.active.set(Boolean.FALSE);
	}
	
	public void stop() {
		this.active.set(Boolean.FALSE);
	}
}
