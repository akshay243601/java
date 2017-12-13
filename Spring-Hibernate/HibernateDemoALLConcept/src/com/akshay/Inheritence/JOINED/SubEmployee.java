package com.akshay.Inheritence.JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="SubEmployeeJOINED")
@PrimaryKeyJoinColumn(name="EmployeeId")
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
