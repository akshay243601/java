package com.akshay.CollectionExamples;


public class EmployeeHashMap
{
	public EmployeeHashMap(int id, String employeeName, String department) {
		super();
		Id = id;
		EmployeeName = employeeName;
		Department = department;
	}

	@Override
	public boolean equals(Object obj) {
		
/*		EmployeeHashMap emp = (EmployeeHashMap)this;
		return this.getEmployeeName().equals(emp.getEmployeeName());
*///		return super.equals(obj);
		return this.getEmployeeName().equals(((EmployeeHashMap)obj).getEmployeeName());
				
	}

	@Override
	public int hashCode() {
		EmployeeHashMap emp = (EmployeeHashMap)this;
/*		if(emp.getId() == 1 || emp.getId() == 2)
		{
			System.out.println("HashCoded Value :-    " + 6);
			return 6;
		}
*/		System.out.println("HashCoded Value :-    " + super.hashCode());
		//return super.hashCode();

		return 7*this.getId();
	}

	@Override
	public String toString()
	{
		return "[Id :-  "+ this.getId() +" , Name :-" + this.getEmployeeName() +" Department :- "+ this.getDepartment() +" ]";
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
