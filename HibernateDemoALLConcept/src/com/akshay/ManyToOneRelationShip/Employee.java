package com.akshay.ManyToOneRelationShip;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="Employee_ManyToOne")
public class Employee 
{
	@Id @GeneratedValue
	private int id;
	
	private String employeeName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private EmployeeAddress employeeAddress;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
	
}
