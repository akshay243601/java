package com.akshay.dirryDataCheck;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DirtyDataCheckUsingVersionDemo {

	public static void main(String[] args) {
		saveEmployee();
	}

	private static void saveEmployee() {
		Employee emp = new Employee();
		emp.setName("Akshay");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tran = session.beginTransaction();
		
		session.save(emp);
		tran.commit();
		
		tran = session.beginTransaction();
		Employee updatedEmp = (Employee)session.load(Employee.class, 10);
		updatedEmp.setName("Akshay s1");
		session.update(updatedEmp);
		tran.commit();
		session.close();
		sessionFactory.close();
	}

}
