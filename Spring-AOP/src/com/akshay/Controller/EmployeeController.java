package com.akshay.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshay.entity.EmpAddress;
import com.akshay.entity.Employee;

public class EmployeeController {
	
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = (Employee)context.getBean(Employee.class);
		System.out.println(emp.getName());
		System.out.println(emp.getAddress().getStreet());
		
		
		EmpAddress empadre = context.getBean("getEmpAddress1", EmpAddress.class);
		EmpAddress empadre1 = context.getBean("getEmpAddress2", EmpAddress.class);
		
		System.out.println(empadre.getStreet());
		empadre1.setStreet("parather wali gali");
		System.out.println(empadre1.getStreet());
		System.out.println(empadre.getStreet());
		
	}
}
