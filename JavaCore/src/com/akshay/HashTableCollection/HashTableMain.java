package com.akshay.HashTableCollection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashTableMain 
{
	public static void main(String args[])
	{
		Hashtable<EmployeeHashTable, Integer> empList = new Hashtable<EmployeeHashTable, Integer>(3, 0.75f);

		
		empList.put(new EmployeeHashTable(1,"Akshay", "Oracle"), 1);
		empList.put(new EmployeeHashTable(1,"Akshay1", "Oracle"), 2);
		empList.put(new EmployeeHashTable(3,"Ram", "Facebook"), 3);
		empList.put(new EmployeeHashTable(4,"Archana", "Microsoft"), 5);
		empList.put(new EmployeeHashTable(5,"Guru Prashad", "Yahoo"), 6);
		empList.put(new EmployeeHashTable(6,"Shilpa", "Google"), 7);
		empList.put(new EmployeeHashTable(7,"Tanu", "Amazon"), 8);
		empList.put(new EmployeeHashTable(8,"Pawan", "Yatra.com"), 4);
		empList.put(new EmployeeHashTable(9,"Srikant", "makeMyTrip"), 1);
		//	empList.put(null, 1);           // we  can not assign null as a Key as well as value even if you override the method still would not be able to allow
		//	empList.put(new EmployeeHashTable(12,"Srikant1", "makeMyTrip"), null);           // we  can not assign null as a Key as well as value even if you override the method still would not be able to allow
		
		for (Entry<EmployeeHashTable, Integer> emp : empList.entrySet()) 
		{
			if(emp != null && emp.getKey() != null)
			{
				EmployeeHashTable employeeDetail = (EmployeeHashTable)emp.getKey();
				System.out.println("Value =>  " + emp.getValue() + " ; Key :- ==> " + employeeDetail.toString());
			}
			else
			{
				System.out.println(" Key :- ==>  null ");
			}
		}
		
		System.out.println("Value =>  " + empList.get(new EmployeeHashTable(1,"Akshay", "Oracle")));
	}
}
