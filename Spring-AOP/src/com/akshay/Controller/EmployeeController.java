package com.akshay.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshay.entity.Employee;

public class EmployeeController {
	
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = (Employee)context.getBean("employee");
		System.out.println(emp.getName());
		System.out.println(emp.getAddress().getStreet());
	}
}
