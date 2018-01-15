package com.akshay.Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Java Program to demonstrate how to use CyclicBarrier, Its used when number of
 * threads needs to wait for each other before starting again.
 * 
 * @author Javin Paul
 */
public class CyclicBarrierDemo {

	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {

		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1");
		Party second = new Party(2000, barrier, "PARTY-2");
		Party third = new Party(3000, barrier, "PARTY-3");
		Party fourth = new Party(4000, barrier, "PARTY-4");
		
		
		Party five = new Party(5000, barrier, "PARTY-5");
		Party six = new Party(6000, barrier, "PARTY-6");
		Party seven = new Party(7000, barrier, "PARTY-7");
		Party eight = new Party(8000, barrier, "PARTY-8");
		
		
		System.out.println(barrier.getNumberWaiting());

		first.start();
		second.start();
		third.start();
		fourth.start();

		five.start();
		six.start();
		seven.start();
		eight.start();

		System.out.println(Thread.currentThread().getName() + " has finished");

	}

}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is calling await()");
            System.out.println(Thread.currentThread().getName() + " running : barrier  Count is : " + barrier.getNumberWaiting() + " before");
            barrier.await();
    		System.out.println(Thread.currentThread().getName() + " running : barrier  Count is : " + barrier.getNumberWaiting() + " after");
            System.out.println(Thread.currentThread().getName() + " has started running again");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
