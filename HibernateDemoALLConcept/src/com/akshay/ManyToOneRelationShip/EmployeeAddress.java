package com.akshay.ManyToOneRelationShip;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table
@Entity
public class EmployeeAddress 
{
	@Id @GeneratedValue
	private int addressId;
	
	private String addressName;
	
	
	//@OneToMany(cascade = CascadeType.ALL)  //If you are not using the mappedBy then Hibernate will create a new Table which contain mapping of EmployeeId and AddressId
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employeeAddress")//If you are using mappedBy then Hibernate will understand then which coloumn is used for mapping purpose and does not create any other table
	private Set<Employee> employee = new HashSet<Employee>();
	
	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
}
