package com.akshay.SerializationExample;

public class ParentEmployee 
{
	private int EmployeeId;
	private String ParentEmployeeName;
	
	public String CheckOverrideVal = "Parent2";
	
	public String parentClassVariable;
	
	
	
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getParentEmployeeName() {
		return ParentEmployeeName;
	}
	public void setParentEmployeeName(String parentEmployeeName) {
		ParentEmployeeName = parentEmployeeName;
	}
	public String getParentEmployeeGender() {
		return ParentEmployeeGender;
	}
	public void setParentEmployeeGender(String parentEmployeeGender) {
		ParentEmployeeGender = parentEmployeeGender;
	}
	private String ParentEmployeeGender;

	
}
