package com.akshay.Inheritence.JOINED;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class JOINEDHierarchyMain 
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
		
        SubEmployee dept1 = new Department();
		
		dept1.setEmployeeName("Akshay_2");
		dept1.setSubEmployeeName("Akshay_SubEmployeeName1");
		
		
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		
		session.beginTransaction();
			
		session.save(emp);
		session.save(subEmp);
		session.save(dept);
		session.save(dept1);

		session.getTransaction().commit();
		session.close();
		
		
	}
}
