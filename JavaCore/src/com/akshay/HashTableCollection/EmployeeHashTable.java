package com.akshay.HashTableCollection;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.views.AbstractView;

public class EmployeeHashTable implements Serializable {
	public EmployeeHashTable(int id, String employeeName, String department) {
		super();
		Id = id;
		EmployeeName = employeeName;
		Department = department;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || this == null ) return false;
		
		return this.getEmployeeName().equals(((EmployeeHashTable) obj).getEmployeeName());

	}

	@Override
	public int hashCode() {

		if (this == null)
			return 1;
		
		EmployeeHashTable emp = (EmployeeHashTable) this;

		System.out.println("HashCoded Value :-    " + super.hashCode());

		return 7 * this.getId();
	}

	@Override
	public String toString() {
		return "[Id :-  " + this.getId() + " , Name :-" + this.getEmployeeName() + " Department :- "
				+ this.getDepartment() + " ]";
	}

	private int Id;
	private String EmployeeName;
	private String Department;

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
