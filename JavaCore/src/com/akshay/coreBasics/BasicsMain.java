package com.akshay.coreBasics;

import java.awt.Point;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.management.StringValueExp;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class ParentClass {
	public static int x = 10;

	public ParentClass() {
		x = 100;
	}

	static void dd() {
		System.out.println("Parent Class Function");
	}

	public void checkExceptionOverriding() throws IOException {

	}
}

public class BasicsMain extends ParentClass {
	static void dd() {
		System.out.println("Child Class Function");
	}

	public void checkExceptionOverriding() throws ArithmeticException {

	}

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static void checkStringBufferContent(StringBuffer sb) {
		sb = new StringBuffer("X");// sb.append("X");
		System.out.println(sb);
	}

	public static int closestToZero(double[] list) {
		if (list == null || (list != null && list.length == 0)) {
			return 0;
		}

		int pos = -1;
		double temp = list[0];
		for (int d = 1; d < list.length; d++) {
			if (temp * temp > list[d] * list[d]) {
				temp = list[d];
				pos = d;
			} else if (temp * temp == list[d] * list[d]) {
				temp = temp > list[d] ? temp : list[d];
				pos = temp > list[d] ? pos : d;

			}
		}

		return pos;
	}

	// isPalingdrome
	public static boolean palingdrome(String val) {
		return val.toLowerCase().equals((new StringBuffer(val.toLowerCase())).reverse().toString());
	}

	// is Palingdrome or not
	public static boolean polingdromeNumberUsingString(int val) {
		String temp = String.valueOf(val);
		return temp.equals(new StringBuffer(temp).reverse().toString());
	}

	// is Palingdrome or not
	public static boolean polingdromeNumber(int val) {
		int temp = 0;
		int x = 0;
		int i = val;
		while (i != 0) {
			temp = i % 10;
			x = x * 10 + temp;
			i = i / 10;

		}
		return x == val;
	}

	// find the no. is factorial or not betwen the range
	public static void printFactorial(int start, int end) {
		System.out.println("Start of fact...");
		for (int i = start; i <= end; i++) {
			if (isFactorial(i)) {
				System.out.println(i);
			}
		}
		System.out.println("Start of fact...");
	}

	// find no, is factorial or not
	public static boolean isFactorial(int val) {
		int temp = 1;
		for (int i = 2; i <= val; i++) {
			temp = temp * i;
			if (temp == val){
				return true;
			}
			else if(temp > val){
				return false;
			}
		}
		return false;
	}

	public static void printPatters() {
		int y = 0;
		for (int x = 1; x <= 4; x++) {
			int tempDotCount = 0;
			int countFot1 = 0;
			countFot1 = (int) Math.pow(2, x);
			tempDotCount = countFot1 - 2;
			for (int z = 1; z <= tempDotCount; z++) {
				System.out.print(".");
			}

			for (int z = 1; z <= countFot1; z++) {
				System.out.print("1");
			}
			System.out.println();
		}
	}

	public static void printDuplicateUsingArray(String[] names) {
		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {
				if (names[i].equals(names[j])) {
					System.out.println(names[i]);
				}
			}
		}
	}

	// find Duplicate element in array
	public static void printDuplicateElementInArray(String[] arr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : arr) {
			if (map.get(s) == null) {
				map.put(s, 1);
			} else {
				Integer val = map.get(s);
				map.put(s, val + 1);
			}
		}

		for (Entry<String, Integer> s : map.entrySet()) {
			if (s.getValue() > 1)
				System.out.println(s.getKey());
		}
	}

	// sort array in ascending order
	public static int[] sortArray(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (temp > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static Object[] sortArrayUsingArrayList(int[] arr) {
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i : arr) {
			arrayList.add(i);
		}

		Collections.sort(arrayList);
		return arrayList.toArray();
	}

	public static void findMiddleElementInLinkedList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(12);
		list.add(32);
		list.add(3);
		list.add(1);
		list.add(20);

		int length = list.size();
		if (length % 2 != 0) {
			System.out.println(list.get((length + 1) / 2 - 1));
		} else {
			System.out.println(list.get((length) / 2 - 1));
		}
	}

	public static ArrayList<String> arr = new ArrayList<String>();

	public static void permutationOfString(String prefix, String val) {
		int n = val.length();
		if (n == 0) {
			System.out.println(prefix);
			arr.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutationOfString(prefix + val.charAt(i), val.substring(0, i) + val.substring(i + 1, n));
			}
		}
	}

	public static void permutationOfStringUsingRecurssion(String val) {
		permutationOfString("", val);
	}

	public static void permutationOfString(String val) {
		byte[] byteArr = val.getBytes();
		ArrayList<String> arrList = new ArrayList<String>();

		for (int i = 0; i < byteArr.length; i++) {
			String temp = String.valueOf((char) byteArr[i]);
			for (int j = 0; j < byteArr.length; j++) {
				if (i != j)
					// continue;
					temp = temp + String.valueOf((char) byteArr[j]);
			}
			if (temp.length() == val.length() && !arrList.contains(temp)) {
				arrList.add(temp);
			}
		}

		Collections.sort(arrList);
		System.out.println(arrList);
	}

	public static void printPrimeNumber(int start, int end) {
		for (int i = start; i < end; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
		}
	}

	public static void StringVal(String val) {
		val = val + "Change";

	}

	public static void method(Object o) {
		System.out.println("Object impl..");
	}
	
	/*public static void method(Integer o) {
		System.out.println("Object impl..");
	}*/

	public static void method(String s) {
		System.out.println("String impl..");
	}

	public static void main(String args[]) {
		

		method(null);
		String s1 = "Sachin";
		String s2 = "Sachin";
		String s3 = new String("Sachin");
		String s4 = "Saurav";
		System.out.println(s1.equals(s2));// true
		System.out.println(s1.equals(s3));// true
		System.out.println(s1.equals(s4));// false

		StringVal(s1);
		System.out.println(s1);
		StringVal(s3);
		System.out.println(s3);

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);

		
		String values = "a,v,b,a,v,a";
		Set<String> splitValues = new HashSet<String>(Arrays.asList(values.split(",")));
		for (String value : splitValues) {
			if (value.trim().length() > 0) {
				System.out.println(value.trim());
			}
		}
		
		
		values = "a,,b,,,,,  ,   ,,   ";
		splitValues = new HashSet<String>(Arrays.asList(values.split(",")));
		for (String value : splitValues) {
			if (value.trim().length() > 0) {
				System.out.println(value.trim());
			}
		}
		System.out.println(splitValues);

		TreeMap<String, Map<String, String>> oldMap = new TreeMap<String, Map<String, String>>();
		oldMap.put("oldMap", new TreeMap<String, String>());
		oldMap.get("oldMap").put("A", "A");
		oldMap.get("oldMap").put("B", "B");
		oldMap.get("oldMap").put("C", "C");

		TreeMap<String, Map<String, String>> newMap = new TreeMap<String, Map<String, String>>();
		newMap.put("newMap", new TreeMap<String, String>());
		newMap.get("newMap").put("A", "A");
		newMap.get("newMap").put("B", "B");
		newMap.get("newMap").put("D", "D");

		Set<String> oldValues = new TreeSet<>();
		oldValues.addAll(oldMap.get("oldMap").keySet());

		Set<String> newValues = new TreeSet<>();
		newValues.addAll(newMap.get("newMap").keySet());

		System.out.println(oldValues);

		System.out.println(newValues);

		newValues.addAll(oldValues);

		System.out.println(newValues);

		final BasicsMain obj = new BasicsMain();
		obj.setI(3);

		System.out.println(obj.getI());
		ArrayList<Integer> ai = new ArrayList<Integer>();
		ai.add(2);
		ai.add(5);
		ai.add(7);
		ai.add(2);
		ai.add(6);
		ai.add(8);
		ai.add(10);

		int b = 3;
		try {
			int x = (Integer) (ai.get(4)) / b;
			System.out.println(x);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Check StringBuffer
		StringBuffer sb = new StringBuffer("A");
		sb.append("B");

		System.out.println(sb);
		checkStringBufferContent(sb);
		System.out.println(sb);
		sb.append("C");
		System.out.println(sb);
		double[] list = { -2, -000000000000.0800000, 10, 21, -1, -5, 14, -1.27, 0.0800000000000, 1 };

		System.out.println(list[closestToZero(list)]);
		System.out.println(palingdrome("sdsd"));
		System.out.println(palingdrome("aaaa"));
		System.out.println(palingdrome("aba"));
		System.out.println(polingdromeNumber(12231));
		System.out.println(polingdromeNumber(32123));
		System.out.println(polingdromeNumberUsingString(12231));
		System.out.println(polingdromeNumberUsingString(32123));
		printFactorial(1, 240);
		printPatters();

		int arrayOfInt[] = sortArray(new int[] { 54, 12, 7, 9, 567, 432, 5, 1, 900 });
		for (int i : arrayOfInt) {
			System.out.print(i + ",");
		}

		System.out.println();
		printDuplicateElementInArray(new String[] { "as", "sd", "1", "3", "1", "sd" });
		printDuplicateUsingArray(new String[] { "as", "sd", "1", "3", "1", "sd" });
		findMiddleElementInLinkedList();

		List<String> ss = Arrays.asList(new String[] { "as", "sd", "1", "3", "1", "sd" });
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println(
		 * "Enter any string"); String a = sc.nextLine(); System.out.println(
		 * "you enter the value :--> " + a); System.out.println(
		 * "Now enter any integer"); int i = sc.nextInt(); System.out.println(
		 * "you enter the value :--> " + i);
		 */

		// permutationOfStringUsingRecurssion("hat");

		// permutationOfStringUsingRecurssion("abc");
		permutationOfStringUsingRecurssion("Z6b");
		Collections.sort(arr);
		System.out.println(arr);
		printPrimeNumber(2, 100);
		System.out.println(getBinary(1323));
		System.out.println(getBinary("1323"));
		System.out.println(getBinary("ad"));
		System.out.println(addTwoBinaryNumber("1232", "124"));
		Point l1 = new Point(0, 10), r1 = new Point(10, 0);
		Point l2 = new Point(5, 5), r2 = new Point(15, 0);
		if (doOverlap(l1, r1, l2, r2))
			System.out.println("Is overlap");
		else
			System.out.println("Rectangles Don't Overlap");

		// check static
		final ParentClass objjj = new BasicsMain();
		objjj.dd();
		// objjj = new ParentClass(); CT Error You can not change the refrence
		// of final object. But if u want to change the attribute value then u
		// can change
		// objjj = new BasicsMain(); CT Error
	}

	public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}
		if (l1.y < r2.y || l2.y < r1.y) {
			return false;
		}
		return true;
	}

	public static String getBinary(int value) {
		return Integer.toBinaryString(value);
	}

	public static String getBinary(String value) {
		String temp = "";
		byte[] bytes;
		try {
			bytes = value.getBytes("UTF-8");
			for (byte b : bytes) {
				temp += Integer.toBinaryString((char) b);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public static String addTwoBinaryNumber(String num1, String num2) {
		String binaryString1 = getBinary(num1);
		String binaryString2 = getBinary(num2);
		System.out.println(binaryString1);
		System.out.println(binaryString2);
		int a = Integer.parseInt(binaryString1, 2);
		int b = Integer.parseInt(binaryString2, 2);

		int add = a + b;
		String binaryOutPut = Integer.toBinaryString(add);
		return binaryOutPut;

	}

	public static String addTwoBinaryNumber(int num1, int num2) {
		String binaryString1 = getBinary(num1);
		String binaryString2 = getBinary(num2);
		System.out.println(binaryString1);
		System.out.println(binaryString2);
		int a = Integer.parseInt(binaryString1, 2);
		int b = Integer.parseInt(binaryString2, 2);

		int add = a + b;
		String binaryOutPut = Integer.toBinaryString(add);
		return binaryOutPut;

	}
}
