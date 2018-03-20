package com.akshay.concurrencyStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImplementation employeeConcStrategyDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public CONCURRENCY_STRATEGY_Employee getUser(int id) {
		CONCURRENCY_STRATEGY_Employee emp = null;
		try{
			 emp = employeeConcStrategyDAO.getUser(id);
		}catch(Exception e){
			System.out.println(e);
		}
		return emp;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public CONCURRENCY_STRATEGY_Employee loadUser(int id) {
		CONCURRENCY_STRATEGY_Employee emp = null;
		try{
			 emp = employeeConcStrategyDAO.loadUser(id);
		}catch(Exception e){
			System.out.println(e);
		}
		return emp;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(CONCURRENCY_STRATEGY_Employee emp) {
		employeeConcStrategyDAO.insertUser(emp);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(CONCURRENCY_STRATEGY_Employee emp) {
		employeeConcStrategyDAO.updateUser(emp);
	}


}
