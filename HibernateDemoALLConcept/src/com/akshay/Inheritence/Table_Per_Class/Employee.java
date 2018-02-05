package com.akshay.Inheritence.Table_Per_Class;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="EmployeePERCLASS")
@Table(name="EmployeePERCLASS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

//	@Id @GeneratedValue
	@Id @GeneratedValue(strategy=javax.persistence.GenerationType.TABLE)
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
