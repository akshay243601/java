package com.akshay.SerializationExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SerializationMain 
{
	public static Object deserializeObject(String filePath)
	{
		Object emp = null;
		try
		{
			FileInputStream fin = new FileInputStream(new File(filePath));
			ObjectInputStream ois = new ObjectInputStream(fin);
			emp = ois.readObject();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return emp;
	}

	public static void serializeObject(Object emp, String filePath)
	{
		try
		{
			FileOutputStream fin = new FileOutputStream(new File(filePath));
			ObjectOutputStream ois = new ObjectOutputStream(fin);
			ois.writeObject(emp);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	
	public static void main(String args[])
	{
		try
		{
			String filePath  = "D:/Study/Dust/SerializedObject.txt";
			
	
/*			ParentEmployee emp = new Employee("A");
			
			System.out.println(emp.CheckOverrideVal);
			//serializeObject(emp, filePath);
			System.out.println(emp.CheckOverrideVal);
			
			
			ParentEmployee p = (ParentEmployee)deserializeObject(filePath);
			System.out.println(p.CheckOverrideVal);
			Employee e = (Employee)deserializeObject(filePath);
			System.out.println(e.CheckOverrideVal);
			*/
			
			Employee emp111 = new Employee("A");
			emp111.parentClassVariable = "ParentClass Val is initialized";
			emp111.childClassVariable = "ChileClass Val is initialized";
			
			
			
			System.out.println(emp111.parentClassVariable);
			serializeObject(emp111, filePath);
			Employee e1111 = (Employee)deserializeObject(filePath);
			System.out.println(e1111.parentClassVariable);

/*			
			Employee emp = new Employee("Akshay Gupta Check Blank Final Variable");
			emp.CompanyName = "Oracle COMPANY";
			emp.setEmployeeId(11);
			emp.setParentEmployeeGender("Male");
			emp.setParentEmployeeName("Rajnikant");
			emp.setId(1);
			emp.setName("Akshay");
			emp.setDepartment("Oracle IT");
			emp.setAddress(new Address());
			emp.getAddress().setAddressId(11);
			emp.getAddress().setAddressname("Hyderabad");
			emp.setCertificates(new ArrayList<Certificate>());
			emp.getCertificates().add(new Certificate(1,"Java"));
			emp.getCertificates().add(new Certificate(2,".Net"));*/
			
			
			
			/*ParentEmployee perEmpForSer = new ParentEmployee();
			
			perEmpForSer.setEmployeeId(11);
			perEmpForSer.setParentEmployeeGender("Male");
			perEmpForSer.setParentEmployeeName("Rajnikant");
			Employee emp1 = new Employee();
			emp1.setId(1);
			emp1.setName("Akshay");
			emp1.setDepartment("Oracle IT");
			emp1.setAddress(new Address());
			emp1.getAddress().setAddressId(11);
			emp1.getAddress().setAddressname("Hyderabad");*/
			/*System.out.println(Employee.CompanyName);

			System.out.println(emp.getName());*/
			
			/*
			serializeObject(emp, filePath);
			System.out.println("Serialization is dome");*/
//			
			Employee empp = (Employee)deserializeObject(filePath);
			System.out.println("de-Serialization is dome");
			System.out.println(empp.CompanyName);
			System.out.println(empp.getName());
		/*	if(emp != null)
			{
				System.out.println(emp);
			}*/
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	/*
	public static void main(String args[])
	{
		try
		{
			
			Certificate cf = new Certificate(1, "Java");
			String filePath  = "D:/Study/Dust/SerializedObject.txt";
			
			
			
			serializeObject(cf, filePath);
			System.out.println("Serialization is dome");
			
			Certificate empp = (Certificate)deserializeObject(filePath);
			System.out.println("de-Serialization is dome");
			if(emp != null)
			{
				System.out.println(emp);
			}
			
			
		}
		catch(Exception e)
		{
			
		}
	}*/

}
