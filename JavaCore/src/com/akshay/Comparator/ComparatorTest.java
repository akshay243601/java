	package com.akshay.Comparator;
	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Collections;
	import java.util.Iterator;
	import java.util.List;
	
	public class ComparatorTest {
	
		public static void main(String[] args)
		{
			List<Employee> users = new ArrayList<Employee>();
		
		users.add(new Employee(1, "Akshay Gupta", "Noida"));
		users.add(new Employee(2, "Sahi. Gupta", "Hyderabad"));
		users.add(new Employee(3, "Karan Gupta", "Noida"));
		users.add(new Employee(4, "Rahul Gupta", "Pune"));
		users.add(new Employee(5, "Akshay Gupta", "Hyderabad"));
		
		System.out.println("Before Sorting");
		System.out.println(users);
		System.out.println();
		Collections.sort(users,new EmployeeNameComparator());
		System.out.println(users);
		
		Collections.sort(users,new EmployeeCityComparator());
		System.out.println(users);

		
		Collections.sort(users,new EmployeeNameAndCityBothComparator());
		System.out.println(users);

	}
}
