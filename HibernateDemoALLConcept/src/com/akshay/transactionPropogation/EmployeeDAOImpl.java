package com.akshay.transactionPropogation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(Employee employee) {
		System.out.println(sessionFactory.getCurrentSession().getTransaction());
		sessionFactory.getCurrentSession().save(employee);
	}
	
	public Employee getUser(int id) {
		System.out.println(sessionFactory.getCurrentSession().getTransaction());
		Employee emp = (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
		return emp;
	}
	
	public Employee loadUser(int id) {
		System.out.println(sessionFactory.getCurrentSession().getTransaction());
		Employee emp = (Employee)sessionFactory.getCurrentSession().load(Employee.class, id);
		return emp;
	}

	
}
