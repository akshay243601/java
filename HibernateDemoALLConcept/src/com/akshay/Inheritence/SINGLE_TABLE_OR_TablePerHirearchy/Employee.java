package com.akshay.Inheritence.SINGLE_TABLE_OR_TablePerHirearchy;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="EmployeeInheritence")
@Table(name="EmployeeInheritence")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("EMP")
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
