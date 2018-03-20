package com.akshay.Multithreading;

class Employee {

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	private int empId;
	private String empName;

}

public class StaticCacheMultiplethreadDemo {
	static Employee emp = new Employee(1, "Akshay");

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread - 1 is running ");
				System.out.println("Thread - 1 " + emp.getEmpName());
				System.out.println("Thread - 1 before update");
				emp.setEmpName("Akshay update With Thread 1");
				System.out.println("Thread - 1 After update");
				System.out.println("Thread - 1 " + emp.getEmpName());
				try {
					synchronized (emp) {
						Thread.sleep(1000);
						emp.wait();
						emp.notify();
					}
					System.out.println("Thread - 1 End");

				} catch (Exception e) {
					System.out.println("Thread - 1 " + e);
				}
			}
		}, "Thread 1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (emp) {
						emp.notify();
						emp.wait();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Thread - 2 is running ");
				System.out.println("Thread - 2 " + emp.getEmpName() + "*******************************************");
				System.out.println("Thread - 2 before update");
				System.out.println("Thread - 2 " + emp.getEmpName() + "*******************************************");
				System.out.println("Thread - 2 after update");
				System.out.println("Thread - 2 End");

			}
		}, "Thread 2");

		t1.start();
		t2.start();
	}
}
