package com.akshay.Inheritence.SINGLE_TABLE_OR_TablePerHirearchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name="SubEmployeeInheritence")
@Table(name="EmployeeInheritence")
@DiscriminatorValue("SUB_EMP")
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
