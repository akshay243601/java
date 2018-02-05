package com.akshay.BasicOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	/**
	 * 
	 */
	private static void persistStateDemo() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		ArrayList<Employee> allEmp  = ((ArrayList<Employee>)session.createQuery("from Employee_Information").list().parallelStream().collect(Collectors.toList()));
		int latestEmpId = allEmp.get(allEmp.size() - 1).getId();
		Employee emp = (Employee) session.get(Employee.class, latestEmpId);
		if (emp != null) {
			System.out.println(emp.getEmployeeName());
		} else {
			emp = new Employee();
			session.persist(emp);
		}
		emp.setEmployeeName("Akshay After Change in Persistent State");
		// No need to write update statement because emp is in persistent state

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

	private static void saveDemo() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEmployeeName("Save Employee With SAVE method");
		session.save(emp);
		
		
		emp.setEmployeeName("vsdvsdvds");
		tran.commit();
		//session.close();

		emp.setEmployeeName("Akshay after close session");

		Session session1 = sessionFactory.openSession();
		Transaction tran1 = session1.beginTransaction();

		session1.update(emp);

		emp.setEmployeeName("Akshay after close session but again create new session");
		tran1.commit();
		session1.close();
		sessionFactory.close();
	}

	private void persistDemo() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		Employee emp = null;

		emp = (Employee) session.get(Employee.class, 3);
		if (emp != null) {
			System.out.println(emp.getEmployeeName());
		} else {
			emp = new Employee();
			session.persist(emp);
		}
		emp.setEmployeeName("Akshay After Change in Persistent State");
		// No need to write update statement because emp is in persistent state

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

	public static void main(String args[]) {
		persistStateDemo();
		saveDemo();
	}

}