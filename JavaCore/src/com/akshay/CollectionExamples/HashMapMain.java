package com.akshay.CollectionExamples;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class HashMapMain {
	public static void main(String args[]) {
		HashMap<EmployeeHashMap, Integer> empList = new HashMap<EmployeeHashMap, Integer>(3, 0.75f);
		empList.put(new EmployeeHashMap(1, "Akshay", "Oracle"), 1);
		empList.put(new EmployeeHashMap(1, "Sameer", "Oracle"), 2);
		empList.put(new EmployeeHashMap(3, "Ram", "Facebook"), 3);
		empList.put(new EmployeeHashMap(4, "Archana", "Microsoft"), 5);
		empList.put(new EmployeeHashMap(5, "Guru Prashad", "Yahoo"), 6);
		empList.put(new EmployeeHashMap(6, "Shilpa", "Google"), 7);
		empList.put(new EmployeeHashMap(7, "Tanu", "Amazon"), 8);
		empList.put(new EmployeeHashMap(8, "Pawan", "Yatra.com"), 4);
		empList.put(new EmployeeHashMap(9, "Srikant", "makeMyTrip"), 1);

		for (Entry<EmployeeHashMap, Integer> emp : empList.entrySet()) {
			EmployeeHashMap employeeDetail = (EmployeeHashMap) emp.getKey();
			System.out.println("Value =>  " + emp.getValue() + " ; Key :- ==> " + employeeDetail.toString());
		}

		System.out.println("Value =>  " + empList.get(new EmployeeHashMap(1, "Akshay", "Oracle")));

		
	
	    Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
	
		
		
	}
}
