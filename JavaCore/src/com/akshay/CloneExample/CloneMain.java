package com.akshay.CloneExample;

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

public class CloneMain 
{

	public static void main(String args[])
	{
		try
		{
		
			
			Employee emp = new Employee();
			emp.setId(1);
			emp.setName("Akshay");
			emp.setDepartment("Oracle IT");
			emp.setAddress(new Address());
			emp.getAddress().setAddressId(11);
			emp.getAddress().setAddressname("Hyderabad");
			emp.setCertificates(new ArrayList<Certificate>());
			emp.getCertificates().add(new Certificate(1,"Java"));
			emp.getCertificates().add(new Certificate(2,".Net"));
			
			
			Employee clonedObj  = (Employee)emp.clone();
			
			System.out.println(emp);
			System.out.println(clonedObj);

			System.out.println(emp.getName());
			System.out.println(clonedObj.getName());
			
			emp.setName("Akshay1");
			
			System.out.println(emp.getName());
			System.out.println(clonedObj.getName());
			
			
			clonedObj.setName("AkshayClonedChange");
			
			System.out.println(emp.getName());
			System.out.println(clonedObj.getName());
			System.out.println(emp);
			System.out.println(clonedObj);

			
			System.out.println(emp.getAddress().getAddressname());
			System.out.println(clonedObj.getAddress().getAddressname());
			
			emp.getAddress().setAddressname("Noida");
			System.out.println(emp.getAddress().getAddressname());
			System.out.println(clonedObj.getAddress().getAddressname());
			
			
			clonedObj.getAddress().setAddressname("Noida    4");
			
			System.out.println(emp.getAddress().getAddressname());
			System.out.println(clonedObj.getAddress().getAddressname());


			
			System.out.println(emp.getAddress());
			System.out.println(clonedObj.getAddress());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
