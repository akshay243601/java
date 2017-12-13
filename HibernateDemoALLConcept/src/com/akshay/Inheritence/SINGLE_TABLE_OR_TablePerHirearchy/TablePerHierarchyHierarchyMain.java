package com.akshay.Inheritence.SINGLE_TABLE_OR_TablePerHirearchy;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class TablePerHierarchyHierarchyMain 
{

	public static void main(String args[])
	{
		Employee emp = new Employee();
		emp.setEmployeeName("Akshay");
		
		
		SubEmployee subEmp = new SubEmployee();
		subEmp.setEmployeeName("Akshay_1");
		subEmp.setSubEmployeeName("Akshay_SubEmployeeName");
		
		Department dept = new Department();
		
		dept.setEmployeeName("Akshay_1");
		dept.setSubEmployeeName("Akshay_SubEmployeeName");
		dept.setDepartmentName("IT");
		
		
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		
		session.beginTransaction();
			
		session.save(emp);
		session.save(subEmp);
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
}
