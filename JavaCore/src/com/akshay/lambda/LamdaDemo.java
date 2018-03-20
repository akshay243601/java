package com.akshay.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name, String address, int age, String number) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.number = number;
	}

	private String address;
	private int age;
	private String number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

public class LamdaDemo {

	public static List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Sameer", "Noida", 24, "8285163098"));
		empList.add(new Employee(2, "Akshay", "USA", 16, "8285112232"));
		empList.add(new Employee(3, "Rachit", "Ghaziabad", 19, "2234163098"));
		empList.add(new Employee(4, "Sushant", "Bihar", 28, "34354098"));
		empList.add(new Employee(5, "Pankaj", "Hyderabad", 34, "822342343"));
		empList.add(new Employee(6, "Kunal", "Bangalore", 21, "434545458"));
		return empList;
	}

	public static void main(String args[]) {
		// lamda expression
		System.out.println("Main is called");

		System.out.println(System.getProperty("java.version"));
		System.setProperty("env", "sdsfsdf");
		System.out.println(System.getProperty("env"));
		Properties properties= System.getProperties();
		List<Employee> empList = getEmpList();
		System.out.println("before Sorting");
		empList.forEach(x -> System.out.print(x.getName() + "    "));

		System.out.println();
		System.out.println(empList.parallelStream().filter(p -> p.getAge() > 10).findFirst().get().getName());

		boolean allMatch = empList.parallelStream().allMatch(x -> x.getNumber().contains("8"));
		System.out.println(allMatch);

		Stream<Employee> employeeStream = empList.stream().filter(x -> x.getName().contains("ks")).distinct();
		employeeStream.forEach(x -> System.out.print(x.getName() + "    "));
		System.out.println();

		Stream<Employee> employeeParrellelStream = empList.parallelStream().filter(x -> x.getName().contains("ks"))
				.distinct();

		employeeParrellelStream.forEach(x -> System.out.print(x.getName() + "    "));
		System.out.println();

		Spliterator<Employee> spliteratorEmployee = empList.stream().spliterator();
		System.out.println("spliteratorEmployee");
		System.out.println(spliteratorEmployee);
		
		empList.stream().sorted((Employee o1, Employee o2) -> {
			return o1.getName().compareTo(o2.getName());
		});

		empList.stream().sorted(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(x -> System.out.print(x.getName() + "     ")); // sorted
		System.out.println();
		System.out.println("After Sorting");
		empList.forEach(x -> System.out.print(x.getName() + "    ")); // it is
																		// not
																		// changed
																		// not
																		// sorted

		
		
		
	}
}
