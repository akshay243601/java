package com.akshay.CollebraProgramms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

class Customer implements Comparable<Customer> {
	public int Id;
	public String Name;
	public String Department;

	public Customer(int id, String name, String department) {
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
		Customer emp = (Customer) obj;
		return this.Name.equals(emp.Name);
	}

	
	@Override
	public int compareTo(Customer emp) {
		return this.Id == emp.Id ? 0 : this.Id > emp.Id ? 1 : -1;
	}

}

public class TreeTest {
	public static void main(String args[]) {
		TreeSet<Customer> treeSet = new TreeSet<Customer>();
		treeSet.add(new Customer(809, "Akshay", "IT"));
		treeSet.add(new Customer(801, "Karan", "CS"));
		treeSet.add(new Customer(805, "sahil", "EC"));
		treeSet.add(new Customer(809, "Rahul", "ME"));
		treeSet.add(new Customer(801, "Karan", "PK"));
		for (Customer Customer : treeSet) {
			System.out.println(Customer.Id + " " + Customer.Name+ " " + Customer.Department);
		}

		TreeMap<Customer, String> treeMap = new TreeMap<Customer, String>();
		//***********************************************************************************************//
		//treeMap.put(null, "Akshay");    //We can't have null key in tree map
		//***********************************************************************************************//
		
		treeMap.put(new Customer(809, "Akshay", "IT"), "Akshay");
		treeMap.put(new Customer(801, "Karan", "CS"), "Karan");
		treeMap.put(new Customer(805, "sahil", "EC"), "Sahil");
		treeMap.put(new Customer(809, "Guru", "ME"), "Guru");
		treeMap.put(new Customer(805, "SRK", "EC"), "Sameer");
	

		for (Entry<Customer, String> entry : treeMap.entrySet()) {
			System.out.println(((Customer) entry.getKey()).Id + " " + ((Customer) entry.getKey()).Name + " " + ((Customer) entry.getKey()).Department + " : " + entry.getValue());
		}
		

	}
}
