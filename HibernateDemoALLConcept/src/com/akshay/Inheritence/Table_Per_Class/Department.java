package com.akshay.Inheritence.Table_Per_Class;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="DepartmentPERCLASS")
@Table(name="DepartmentPERCLASS")
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
