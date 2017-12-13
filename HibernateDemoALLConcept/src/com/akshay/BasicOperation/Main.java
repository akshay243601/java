package com.akshay.BasicOperation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main 
{
	public static void main(String args[])
	{	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		Employee emp = (Employee)session.get(Employee.class, 1);
		System.out.println(emp.getEmployeeName());
		
		emp.setEmployeeName("Akshay After Change in Persistent State");
		//No need to write update statement because emp is in persistent state
		
		tran.commit();
		session.close();
		
		emp.setEmployeeName("Akshay after close session");
		
		Session session1 = sessionFactory.openSession();
		Transaction tran1 = session1.beginTransaction();

		session1.update(emp);
		
		emp.setEmployeeName("Akshay after close session but again create new session");
		tran1.commit();
		session1.close();
		sessionFactory.close();
		
	}
}