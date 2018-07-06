package com.akshay.synchronizationDemo;


public class SynchronizationDemo extends Thread {

	Employee emp  = null;
	public SynchronizationDemo(Employee emp){
		this.emp = emp;
	}
	
	
	public static void main(String[] args) {
		Employee emp = new Employee();

		System.out.println("started...");

		SynchronizationDemo thread1 = new SynchronizationDemo(emp) {
			@Override
			public void run() {
				emp.printOdd(this.getName());
			}
		};
		
		thread1.setName("thread1");
		SynchronizationDemo thread2 = new SynchronizationDemo(emp) {
			@Override
			public void run() {
				emp.printEven(this.getName());
			}
		};
		thread2.setName("thread2");

		thread1.start();
		thread2.start();

	}

}
