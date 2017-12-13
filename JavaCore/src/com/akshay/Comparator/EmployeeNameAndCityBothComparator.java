package com.akshay.Comparator;

import java.util.Comparator;

public class EmployeeNameAndCityBothComparator implements Comparator<Employee> 
{
	@Override
	public int compare(Employee emp1, Employee emp2) {
		int i = emp1.getName().compareTo(emp2.getName());
		if( i == 0 )
		{
			i = emp1.getCity().compareTo(emp2.getCity());
		}
		return i;
	}
}
