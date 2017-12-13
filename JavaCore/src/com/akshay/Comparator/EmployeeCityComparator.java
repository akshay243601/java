package com.akshay.Comparator;

import java.util.Comparator;

public class EmployeeCityComparator implements Comparator<Employee> 
{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getCity().compareTo(emp2.getCity());
	}
}
