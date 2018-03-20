package com.akshay.Inheritence.JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DepartmentJOINED")
@PrimaryKeyJoinColumn(name="EmployeeId")
public class Department extends SubEmployee
{
	private String DepartmentName;

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	
}
