package com.akshay.Inheritence.Table_Per_Class;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name="SubEmployeePERCLASS")
@Table(name="SubEmployeePERCLASS")
public class SubEmployee extends Employee
{
	private String SubEmployeeName;

	public String getSubEmployeeName() {
		return SubEmployeeName;
	}

	public void setSubEmployeeName(String subEmployeeName) {
		SubEmployeeName = subEmployeeName;
	}
	

}
