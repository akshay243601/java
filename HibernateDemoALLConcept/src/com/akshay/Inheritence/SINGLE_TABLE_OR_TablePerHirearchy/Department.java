package com.akshay.Inheritence.SINGLE_TABLE_OR_TablePerHirearchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeInheritence")
@DiscriminatorValue("DEPT")
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
