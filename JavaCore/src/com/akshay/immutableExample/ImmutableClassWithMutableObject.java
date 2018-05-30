package com.akshay.immutableExample;


//Immutable Class
final class Employee {
	private final int id;
	private final String name;
	
	//mutable type object
	private final Address address;
	
	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
		System.out.println("Constructor block");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		//return clone everytime
		Address cloneAddress = new Address(this.address.getId(), this.address.getCity());
		return cloneAddress;
	}

}


//Mutable Class
class Address {
	int id;
	String city;

	public Address(int id, String city) {
		this.id = id;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

public class ImmutableClassWithMutableObject {

	public static void main(String[] args) {
		
		Employee emp = new Employee(1, "Akshay", new Address(10, "Delhi"));
		System.out.println(emp.getAddress().getCity());
		System.out.println(emp.getAddress());
		emp.getAddress().setCity("Budaun");
		System.out.println(emp.getAddress().getCity());   //it will give you same result.
		System.out.println(emp.getAddress());		
		
		
	}

}
