package com.akshay.Comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args)
	{
		List<User> users = new ArrayList<User>();
		
		users.add(new User(1, "Akshay Gupta", "Noida"));
		users.add(new User(2, "Sahi. Gupta", "Hyderabad"));
		users.add(new User(3, "Karan Gupta", "Noida"));
		users.add(new User(4, "Rahul Gupta", "Pune"));
		users.add(new User(5, "Akshay Gupta", "Hyderabad"));
		
		System.out.println("Before Sorting");
		System.out.println(users);
		System.out.println();
		Collections.sort(users);
		System.out.println(users);
	}
}
