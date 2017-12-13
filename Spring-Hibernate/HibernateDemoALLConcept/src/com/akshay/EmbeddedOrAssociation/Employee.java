package com.akshay.EmbeddedOrAssociation;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeForEmbedded")
public class Employee 
{
	@Id @GeneratedValue
	private int EmployeeId;
	private String Name;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="AddressName", column = @Column(name="ADDR_NAME") ) })
	private Address Address;
	
	public int getEmployeeId() {
		return EmployeeId;
	}
	
	public String getName() {
		return Name;
	}
	
	public Address getAddress() {
		return Address;
	}
	
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public void setAddress(Address address) {
		Address = address;
	}
}
