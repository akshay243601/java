package com.akshay.SerializationExample;

import java.io.Serializable;
import java.util.List;

public class Employee extends ParentEmployee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String CompanyName;
	
	private int id;
	
	private static String Name;
	
	private Address address;
	
	private String Department;
	
	//check for Final Variable serialize or not
	public final String checkFinalVariable;
	
	public final String checkForFinalHavingValue="Value of final Variable CCCCCCCCCCCCCCCCCCCCC";
	
	public String CheckOverrideVal = "Employee2";
	
	public String childClassVariable;
	
	private List<Certificate> certificates;
	
	public Employee(String x) {
		checkFinalVariable = "CCCCCCCCCCCCCCCCCCC";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public void setDepartment(String department) {
		Department = department;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
	


}
