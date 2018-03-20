package com.akshay.Multithreading;


public class VolatileExample extends Thread{
	static Employee emp = new Employee(1, "Akshay");
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName() + " is running ");
		System.out.println(Thread.currentThread().getName()  + emp.getEmpName());
		//System.out.println(Thread.currentThread().getName() + " before update");
		if(!Thread.currentThread().getName().equalsIgnoreCase("T2")){
			try{
				 Thread.sleep(1000);
		
			}
			catch(Exception ex){
				
			}
			emp.setEmpName("Akshay update With " + Thread.currentThread().getName());
		} else {

			try{
				
				 Thread.sleep(1000);
			}
			catch(Exception ex){
				
			}
			emp.setEmpName("Akshay update With " + Thread.currentThread().getName());
		
		}
		//System.out.println(Thread.currentThread().getName() + " After update");
		System.out.println(Thread.currentThread().getName() + emp.getEmpName());
		try{
			notifyAll();
		} catch (Exception e){
			
		}
	}

	
	public static void main(String[] args) {
		
		VolatileExample t1 = new VolatileExample();
		t1.setName("T1");
		VolatileExample t2 = new VolatileExample();
		t2.setName("T2");
		t1.start();
		t2.start();
	}
}
