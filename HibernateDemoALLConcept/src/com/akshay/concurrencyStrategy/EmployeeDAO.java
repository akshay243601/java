package com.akshay.concurrencyStrategy;

public interface EmployeeDAO {
	void insertUser(CONCURRENCY_STRATEGY_Employee employee);

	CONCURRENCY_STRATEGY_Employee getUser(int id);

	CONCURRENCY_STRATEGY_Employee loadUser(int id);
	
	void updateUser(CONCURRENCY_STRATEGY_Employee employee);
}
