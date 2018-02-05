package com.akshay.Inheritence.JOINED;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="EmployeeJOINED")
@Table(name="EmployeeJOINED")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

	@Id @GeneratedValue
	private int EmployeeId;
	private String EmployeeName;

	public int getEmployeeId() {
		return EmployeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

}
