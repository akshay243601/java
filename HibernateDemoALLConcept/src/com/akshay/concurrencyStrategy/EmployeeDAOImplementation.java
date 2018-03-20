package com.akshay.concurrencyStrategy;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImplementation implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(CONCURRENCY_STRATEGY_Employee employee) {
		sessionFactory.getCurrentSession().persist(employee);
	}
	
	public void updateUser(CONCURRENCY_STRATEGY_Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}

	public CONCURRENCY_STRATEGY_Employee getUser(int id) {
		CONCURRENCY_STRATEGY_Employee emp = (CONCURRENCY_STRATEGY_Employee)sessionFactory.getCurrentSession().get(CONCURRENCY_STRATEGY_Employee.class, id);
		return emp;
	}
	
	public CONCURRENCY_STRATEGY_Employee loadUser(int id) {
		CONCURRENCY_STRATEGY_Employee emp = (CONCURRENCY_STRATEGY_Employee)sessionFactory.getCurrentSession().load(CONCURRENCY_STRATEGY_Employee.class, id);
		return emp;
	}

	
}
