package com.akshay.ManyToOneRelationShip;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main 
{
	public static void main(String args[])
	{
		EmployeeAddress address = new EmployeeAddress();
		address.setAddressName("Hyderabad");
		
		Employee employee = new Employee();
		employee.setEmployeeName("Akshay");
		employee.setEmployeeAddress(address);
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Karan");
		employee1.setEmployeeAddress(address);
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

//		session.save(employee);
//		session.save(employee1);
//		OR  down line code
		
		address.getEmployee().add(employee);
		address.getEmployee().add(employee1);
		session.save(address);
		
		tran.commit();
		session.close();
		sessionFactory.close();
	}
}