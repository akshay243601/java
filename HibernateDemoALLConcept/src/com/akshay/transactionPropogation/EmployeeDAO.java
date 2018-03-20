package com.akshay.transactionPropogation;

public interface EmployeeDAO {
	void insertUser(Employee employee);

	Employee getUser(int id);

	Employee loadUser(int id);

}
