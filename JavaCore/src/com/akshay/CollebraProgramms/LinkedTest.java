package com.akshay.CollebraProgramms;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;



class Person {
	public int Id;
	public String Name;

	public Person(int id, String name) {
		this.Id = id;
		this.Name = name;
	}
	
	@Override
	public int hashCode() {
		return this.Id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person emp = (Person)obj;
		return this.Name.equals(emp.Name);
	}
}

public class LinkedTest 
{
	public static void main(String args[])
	{	
		LinkedList<String> ls = new LinkedList<String>();
		ls.add("X");
		ls.add("Y");
		ls.add("Z");
		ls.add("A");
		ls.add("B");
		ls.add("C");
		ls.add("D");
		
		for (String string : ls) {
			System.out.println(string);
		}
		
		LinkedHashSet<String> list = new LinkedHashSet<String>();
	
		list.add("Akshay");
		list.add("Karan");
		list.add("Priyanka");
		list.add("Sandy");
		list.add("Priya");
		list.add("Priya");
		list.add("Shikha");
		list.add("Priyanka");
		list.add("Sadhana");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<String,Integer>();
		linkedMap.put("Akshay", 1);
		linkedMap.put("Karan", 10);
		linkedMap.put("Sahil", 12);
		linkedMap.put("Prem", 32);
		linkedMap.put("Karan", 45);		
		for (Entry<String,Integer> entry : linkedMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		LinkedList<Person> linkedList = new LinkedList<Person>();
		linkedList.add(new Person(809, "Akshay"));
		linkedList.add(new Person(801, "Karan"));
		linkedList.add(new Person(805, "sahil"));
		for (Person employee : linkedList) {
			System.out.println(employee.Id + " " + employee.Name);
		}

		LinkedHashSet<Person> linkedHashSet = new LinkedHashSet<Person>();
		linkedHashSet.add(new Person(809, "Akshay"));
		linkedHashSet.add(new Person(801, "Karan"));
		linkedHashSet.add(new Person(805, "sahil"));
		linkedHashSet.add(new Person(809, "Akshay"));
		for (Person employee : linkedHashSet) {
			System.out.println(employee.Id + " " + employee.Name);
		}

		LinkedHashMap<Person, String> linkedHashMap = new LinkedHashMap<Person, String>();
		linkedHashMap.put(new Person(809, "Akshay"), "Akshay");
		linkedHashMap.put(new Person(801, "Karan"), "Karan");
		linkedHashMap.put(new Person(805, "sahil"), "Sahil");
		linkedHashMap.put(new Person(809, "Guru"), "Guru");

		for (Entry<Person, String> entry : linkedHashMap.entrySet()) {
			System.out.println(((Person)entry.getKey()).Id + " " + ((Person)entry.getKey()).Name  + " : " + entry.getValue());
		}

	}
}