package com.akshay.multithreading;

public class TwoThreadPrintSequentialNumber {

	public int MAX_COUNT = 50;
	public int COUNT = 0;
	public boolean isOdd = false;
	public void printEven(){
		
		synchronized (this) {
			while(COUNT <= MAX_COUNT){
				while(isOdd){
					try{
						wait();
					} catch (Exception e){
						System.out.println(e);
					}
				}
				System.out.println("EVEN :  " + COUNT);
				COUNT++;
				isOdd = true;
				notify();
			}
			
		}
		
	}
	public void printOdd(){
		
		synchronized (this) {
			while(COUNT <= MAX_COUNT){
				while(!isOdd){
					try{
						wait();
					} catch (Exception e){
						System.out.println(e);
					}
				}
				
				System.out.println("ODD :  " + COUNT);
				COUNT++;
				isOdd = false;
				notify();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		TwoThreadPrintSequentialNumber obj = new TwoThreadPrintSequentialNumber();
		
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printEven();
			}
		});
		
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printOdd();
			}
		});

		th1.start();
		th2.start();

	}

}
