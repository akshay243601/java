package com.akshay.collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindDuplicateAndRemove {

	public static void main(String args[]) {

		LinkedList<String> arr = new LinkedList<String>();
		arr.add("Akshay");
		arr.add("Sunil");
		arr.add("Rajesh");
		arr.add("Shreshth");
		arr.add("Akshay");
		arr.add("Sourabh");

		System.out.println(arr);
		Set<String> set = new HashSet<String>();
		arr.stream().parallel().forEach(x -> {
			set.add(x);
			System.out.println(x);
		});

		System.out.println(set);

	}
}
