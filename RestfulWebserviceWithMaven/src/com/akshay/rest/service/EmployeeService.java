package com.akshay.rest.service;

import com.akshay.rest.dao.EmployeeDAO;
import com.akshay.rest.dao.SessionFactoryBLImpl;
import com.akshay.rest.entity.Employee;

public class EmployeeService {

	public static EmployeeDAO employeeDAO = null;

	public Employee getEmployee(int id) {
		return EmployeeService.getEmployeeDAO().getEmployee(id);
	}

	public boolean saveEmployee(Employee emp) {
		return EmployeeService.getEmployeeDAO().saveEmployee(emp);
	}

	public static EmployeeDAO getEmployeeDAO() {
		if (employeeDAO == null) {
			synchronized (SessionFactoryBLImpl.class) {
				if (employeeDAO == null) {
					employeeDAO = new EmployeeDAO();
				}
			}
		}
		return employeeDAO;
	}

}
