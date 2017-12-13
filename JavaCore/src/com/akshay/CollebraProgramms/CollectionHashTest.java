package com.akshay.CollebraProgramms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {
	public int Id;
	public String Name;
	public String Department;

	public Employee(int id, String name, String department) {
		this.Id = id;
		this.Name = name;
		this.Department = department;
	}

	@Override
	public int hashCode() {
		return this.Id;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return this.Name.equals(emp.Name);
	}

	
	@Override
	public int compareTo(Employee emp) {
		return this.Id == emp.Id ? 0 : this.Id > emp.Id ? 1 : -1;
	}

}

public class CollectionHashTest {
	public static void main(String args[]) {
		ArrayList<Employee> ls = new ArrayList<Employee>();
		ls.add(new Employee(809, "Akshay", "IT"));
		ls.add(new Employee(801, "Karan", "CS"));
		ls.add(new Employee(805, "sahil", "EC"));
		for (Employee employee : ls) {
			System.out.println(employee.Id + " " + employee.Name + " " + employee.Department);
		}

		HashSet<Employee> set = new HashSet<Employee>();
		set.add(new Employee(809, "Akshay", "IT"));
		set.add(new Employee(801, "Karan", "CS"));
		set.add(new Employee(805, "sahil", "EC"));
		set.add(new Employee(809, "Krunal", "ME"));
		for (Employee employee : set) {
			System.out.println(employee.Id + " " + employee.Name + " " + employee.Department);
		}

		TreeSet<Employee> treeSet = new TreeSet<Employee>();
		treeSet.add(new Employee(809, "Akshay", "IT"));
		treeSet.add(new Employee(801, "Karan", "CS"));
		treeSet.add(new Employee(805, "sahil", "EC"));
		treeSet.add(new Employee(809, "Rahul", "ME"));
		treeSet.add(new Employee(801, "Karan", "PK"));
		for (Employee employee : treeSet) {
			System.out.println(employee.Id + " " + employee.Name+ " " + employee.Department);
		}

		TreeMap<Employee, String> treeMap = new TreeMap<Employee, String>();
		treeMap.put(new Employee(809, "Akshay", "IT"), "Akshay");
		treeMap.put(new Employee(801, "Karan", "CS"), "Karan");
		treeMap.put(new Employee(805, "sahil", "EC"), "Sahil");
		treeMap.put(new Employee(809, "Guru", "ME"), "Guru");

		for (Entry<Employee, String> entry : treeMap.entrySet()) {
			System.out.println(((Employee) entry.getKey()).Id + " " + ((Employee) entry.getKey()).Name + " " + ((Employee) entry.getKey()).Department + " : " + entry.getValue());
		}
	}
}
