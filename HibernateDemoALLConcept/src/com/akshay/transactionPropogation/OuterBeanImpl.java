package com.akshay.transactionPropogation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class OuterBeanImpl implements OuterBean {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private InnerBean innerBean;

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_Required(Employee employee) {
		employeeDAO.insertUser(employee);
		try {

			Employee emp = new Employee();
			emp.setName("Inner Transaction EMP" + employee.getName());
			emp.setUsername("Inner Transaction EMP" + employee.getUsername());

			innerBean.test_Required(employee);
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_RequiresNew(Employee employee) {
		employeeDAO.insertUser(employee);
		try {

			Employee emp = new Employee();
			emp.setName("Inner Transaction EMP" + employee.getName());
			emp.setUsername("Inner Transaction EMP" + employee.getUsername());

			innerBean.test_RequiresNew(emp);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_NEVER(Employee employee) {
		try {
			innerBean.test_NEVER(employee);
		} catch (Exception e) {
			System.out.println(e);
		}

		employee.setName("UPDATED");
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public void test_MANDATORY(Employee employee) {
		try {
			innerBean.test_MANDATORY(employee);
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_SUPPORTED(Employee employee) {
		employeeDAO.insertUser(employee);
		try {
			Employee emp = new Employee();
			emp.setName("Inner Transaction EMP" + employee.getName());
			emp.setUsername( "Inner Transaction EMP" + employee.getUsername());
			
			//If exception occur it will roll the current transaction as well.
			innerBean.test_SUPPORTED(emp);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_NOT_SUPPORTED(Employee employee) {
		employeeDAO.insertUser(employee);
		try {
			Employee emp = new Employee();
			emp.setName("Inner Transaction EMP" + employee.getName());
			emp.setUsername( "Inner Transaction EMP" + employee.getUsername());
			
			//If exception occur it will roll the current transaction as well.
			innerBean.test_NOT_SUPPORTED(emp);
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_NESTED(Employee employee) {
		try {
			innerBean.test_NESTED(employee);
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void test_TRSANSACTION_OPERATIONS(Employee employee) {
		employeeDAO.insertUser(employee);
		try {

			
			Employee emp = new Employee();
			emp.setName("Inner Transaction EMP" + employee.getName());
			emp.setUsername( "Inner Transaction EMP" + employee.getUsername());
			 

			innerBean.test_Required(employee);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		
		//No Query fire at the end one query fire for update because they all are in same transaction
		employeeDAO.getUser(employee.getId());
		employeeDAO.getUser(employee.getId());
		employee.setName("asds");
		employeeDAO.getUser(employee.getId());
		employee.setName("asds1");
		employeeDAO.getUser(employee.getId());
		employee.setUsername("asds1");
		
		
/*   THIS IS THE OUTPUT
 * 
   		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		Hibernate: insert into Propogation_Employee (NAME, USERNAME) values (?, ?)
		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction@4b7e96a
		Hibernate: update Propogation_Employee set NAME=?, USERNAME=? where ID=?
*/				
				
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Employee getUser(int id) {
		Employee emp = null;
		try{
			 emp = employeeDAO.getUser(id);
		}catch(Exception e){
			System.out.println(e);
		}
		return emp;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Employee loadUser(int id) {
		Employee emp = null;
		try{
			 emp = employeeDAO.loadUser(id);
		}catch(Exception e){
			System.out.println(e);
		}
		return emp;
	}

}
