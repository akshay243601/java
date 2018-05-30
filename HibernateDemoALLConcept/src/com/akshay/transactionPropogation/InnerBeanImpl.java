package com.akshay.transactionPropogation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class InnerBeanImpl implements InnerBean {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public void test_Required(Employee employee) {
		employeeDAO.insertUser(employee);
		
		/***
		 * 
		 * If this transaction fail then parent transaction are also rollbacked.
		 * 
		 * **/
		throw new RuntimeException("Rollback this transaction!");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void test_RequiresNew(Employee employee) {
		employeeDAO.insertUser(employee);
		
		
		/****
		 * 
		 *  IF this transaction is failed parent transaction will not affected. 
		 * 
		 * ****/
		
		throw new RuntimeException("Rollback this transaction!");
	}

	@Transactional(propagation = Propagation.NEVER)
	public void test_NEVER(Employee employee) {
		
		/****
		 * 
		 * If there will be any open transaction Then it will be fail.
		 * 
		 * 
		 * *****/
		
		
		employeeDAO.insertUser(employee);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void test_MANDATORY(Employee employee) {
		
		/****
		 * 
		 * If there will be no open transaction Then it will be fail.
		 * 
		 * 
		 * *****/

		
		employeeDAO.insertUser(employee);

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void test_SUPPORTED(Employee employee) {
		
		/**
		 * It will execute irrespective of a tx. 
		 * If a tx is running, it will participate in the same tx. 
		 * If executed without a tx it will still execute if no errors.
		 * If exception occur it will rollback parent transaction as well.
		 * **/
		
		employeeDAO.insertUser(employee);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void test_NOT_SUPPORTED(Employee employee) {
		employeeDAO.insertUser(employee);
		
		//It will not rollback current transaction. As it is NOT_SUPPORTED transaction. and its not participate in any transaction 
		/**
		 * AS IT IS EXECUTE OUTSIDE THE TRANSACTION
		 * SO MATTER IF A EXCEPTION OCCUR AFTER insertUser(employee) IT WILL NOT ROLLBACK TRANSACTION 
		 * 
		 * **/
		throw new RuntimeException("Rollback this transaction!");

	}

	@Transactional(propagation = Propagation.NESTED)
	public void test_NESTED(Employee employee) {
		employeeDAO.insertUser(employee);
		

	}

}
