package com.akshay.rest.dao;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akshay.rest.entity.Employee;

public class EmployeeDAO {

	public Employee getEmployee(int id) {
		SessionFactory sessionfactory = SessionFactoryBLImpl.getSessionFactory();
		Employee emp = (Employee) sessionfactory.openSession().get(Employee.class, id);
		return emp;
	}

	public boolean saveEmployee(Employee emp) {
		SessionFactory sessionfactory = SessionFactoryBLImpl.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction trx = null;
		boolean isSave = false;
		try {
			trx = session.beginTransaction();
			session.persist(emp);
			trx.commit();
			isSave = true;
		} catch (Exception ex) {
			if(trx != null &&  trx.isActive()){
				trx.rollback();
			}
			System.out.println(ex);
		} finally {
			
		}
		return isSave;
	}

}
