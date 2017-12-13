package com.akshay.coreBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

public class HireVueDeloitee {

	public static ArrayList<Integer> getSubArray(int arr[]) {
		ArrayList<Integer> subArr = new ArrayList<Integer>();
		int temp = -1;
		int index = -1;
		int indexTillAdd = -1;
		for (int i = 0; i < arr.length; i++) {
			if (temp > arr[i]) {
				index = i;
				subArr.add(arr[i]);
			} else {
				indexTillAdd = i;
				temp = arr[i];
			}

			if (index > indexTillAdd) {
				for (int j = index - 1; j <= indexTillAdd; j++) {
					subArr.add(arr[j]);
				}
				index = indexTillAdd;
			}
		}

		return subArr;
	}

	public static void printUnsorted(int arr[], int n) {
		int s = 0, e = n - 1, i, max, min;

		// step 1(a) of above algo
		for (s = 0; s < n - 1; s++) {
			if (arr[s] > arr[s + 1])
				break;
		}
		if (s == n - 1) {
			System.out.println("The complete array is sorted");
			return;
		}

		// step 1(b) of above algo
		for (e = n - 1; e > 0; e--) {
			if (arr[e] < arr[e - 1])
				break;
		}

		// step 2(a) of above algo
		max = arr[s];
		min = arr[s];
		for (i = s + 1; i <= e; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

		// step 2(b) of above algo
		for (i = 0; i < s; i++) {
			if (arr[i] > min) {
				s = i;
				break;
			}
		}

		// step 2(c) of above algo
		for (i = n - 1; i >= e + 1; i--) {
			if (arr[i] < max) {
				e = i;
				break;
			}
		}

		// step 3 of above algo
		System.out.println(" The unsorted subarray which makes the given array  sorted lies between the indees " + s
				+ " and  " + e);
		return;
	}

	public static ArrayList<Integer> getSortedSubArray(int arr[]) {
		ArrayList<Integer> subArr = new ArrayList<Integer>();
		int n = arr.length;
		int min, max, i = 0, j = n - 1;

		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		if (i == arr.length - 1) {
			System.out.println("Array is already sorted....");
		}

		for (j = n - 1; j > 0; j--) {
			if (arr[j] < arr[j - 1]) {
				break;
			}
		}

		min = arr[j];
		max = arr[j];
		System.out.println("Before Sorting :-  Minimum :-  " + min + "  ,   Maximum :-  " + max);

		for (int k = i; k <= j - 1; k++) {
			if (arr[k] > max) {
				max = arr[k];
			}

			if (arr[k] < min) {
				min = arr[k];
			}
		}

		System.out.println("After Sorting :-  Minimum :-  " + min + "  ,   Maximum :-  " + max);

		for (int k = 0; k < i; k++) {
			if (arr[k] > min) {
				i = k;
				break;
			}
		}

		for (int k = n - 1; k > j; k--) {
			if (arr[k] < max) {
				j = k;
				break;
			}
		}

		for (int p = i; p <= j; p++) {

			subArr.add(arr[p]);
		}

		return subArr;
	}

	// find Short array in which if we remove that sub Array then array will be
	// sorted

	public static void main(String args[]) {

		int arr[] = { 10, 12, 11, 30, 25, 21, 32, 35, 9, 50, 60 };
		int arr_size = arr.length;
		printUnsorted(arr, arr_size);
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Please Length of Array"); int length =
		 * sc.nextInt();
		 * 
		 * System.out.println("Please enter element in array"); int arr[] = new
		 * int[length]; for(int i = 0; i < arr.length ; i++) { arr[i] =
		 * sc.nextInt(); } System.out.println(getSubArray(arr));
		 */
		System.out.println(getSortedSubArray(arr));
		System.out.println(getSortedArray(arr));

		int a[] = { 1, 3, 2, 4, 5, 6 };
		int b[] = { 4, 2, 3, 6, 8, 1, 9 };
		IntersectionOfTwoSortedArray(a, b);

		int c[] = { 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 9, 10, 11, 12, 12, 13, 14, 14 };
		findElementWithOneOccurence(c);

		FindKthSmallestElement(c, 4);
		FindKthSmallestElement(a, 4);
		FindKthSmallestElement(b, 5);

		int d[] = { 6, 4, 2, 7, 22, 3, 6, 2, 1, 3, 4, 6, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4,
				4, 4, 4, 4 };
		FindKthSmallestElement(d, 2);

		int[] a1 = { 1, 2, 3, 5, 6, 7 };
		int[] b1 = { 1, 2, 4, 8, 6, 7 };
		int[] c1 = { 1, 9, 3, 5, 6, 7 };
		GetCommonElementIn3Array(a1, b1, c1);
		
		
		int[] a12 = {5,3,2,6,1,10,32,22,56,24,1,1,1,1,2,454,232};
		FindTwoTopNumber(a12);
	}

	public static ArrayList<Integer> getSortedArray(int arr[]) {
		int min, max, i, n = arr.length, j;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		for (j = n - 1; j > 0; j--) {
			if (arr[j] < arr[j - 1]) {
				break;
			}
		}

		max = arr[j];
		min = arr[j];
		for (int x = i; x <= j - 1; x++) {
			if (arr[x] < min) {
				min = arr[x];
			}

			if (arr[x] > max) {
				max = arr[x];
			}
		}

		for (int x = 0; x < i; x++) {
			if (arr[x] > min) {
				i = x;
				break;
			}
		}

		for (int x = j - 1; x > j; x--) {
			if (arr[x] < max) {
				j = x;
				break;
			}
		}

		ArrayList<Integer> subArr = new ArrayList<Integer>();
		for (int x = i; x <= j; x++) {
			subArr.add(arr[x]);
		}
		return subArr;
	}

	// Get Sum of two boolean numbers
	public static String getSumOfBoolean(String binary1, String binary2) {
		int num1 = Integer.parseInt(binary1, 2);
		int num2 = Integer.parseInt(binary2, 2);
		int sum = num1 + num2;
		return Integer.toBinaryString(sum);
	}

	// Write a program to find intersection of two sorted array in Java?
	public static void IntersectionOfTwoSortedArray(int[] a, int[] b) {
		TreeSet<Integer> interSect = new TreeSet<Integer>();
		ArrayList<Integer> interSectArr = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (!interSect.add(a[i])) {
				interSectArr.add(a[i]);
			}
		}

		for (int i = 0; i < b.length; i++) {
			if (!interSect.add(b[i])) {
				interSectArr.add(b[i]);
			}
		}

		System.out.println(interSectArr);
	}

	// There is an array with every element repeated twice except one. Find that
	// element? (solution)
	public static void findElementWithOneOccurence(int[] a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer integer : a) {
			list.add(integer);
		}

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size() && list.get(i) == list.get(i + 1)) {
				i++;
			} else {
				System.out.println("Single Occurenece Element is :- " + list.get(i));
				// break;
			}
		}
	}

	// How to find kth smallest element in unsorted array? (solution)
	public static void FindKthSmallestElement(int[] a, int kthElement) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer integer : a) {
			if (!list.contains(integer)) {
				list.add(integer);
			}
		}
		Collections.sort(list);
		System.out.println("Kth sortest Elemenet is :- " + list.get(kthElement - 1));
	}

	// How to find common elements in three sorted array? (solution)
	public static void GetCommonElementIn3Array(int a[], int b[], int c[]) {
		HashMap<Integer, Integer> _map = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < a.length ;  i++) {
			if (_map.containsKey(a[i])) {
				int count = _map.get(a[i]);
				count++;
				_map.put(a[i], count);
			} else {
				_map.put(a[i], 1);
			}
		}

		for (int i = 0 ; i < b.length ;  i++) {
			if (_map.containsKey(b[i])) {
				int count = _map.get(b[i]);
				count++;
				_map.put(b[i], count);
			} else {
				_map.put(b[i], 1);
			}
		}

		for (int i = 0 ; i < c.length ;  i++) {
			if (_map.containsKey(c[i])) {
				int count = _map.get(c[i]);
				count++;
				_map.put(c[i], count);
			} else {
				_map.put(c[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : _map.entrySet()) {
			if (entry.getValue() == 3) {
				System.out.println("Key  :-   " + entry.getKey() + "  Value :-  " + entry.getValue());
			}
		}
	}
	
	//5,3,2,6,1,10,32,22
	//How to find top two numbers from an integer array? (solution)
	public static void FindTwoTopNumber(int a[])
	{
		int firstTop = a[0];
		int secondTop = a[1];
		if(firstTop < secondTop)
		{
			firstTop = a[1];
			secondTop = a[0];
		}
		
		for(int i = 2; i < a.length ; i++)
		{
			if(firstTop > a[i] && secondTop < a[i])
			{
				secondTop = a[i];
			}
			else if(firstTop < a[i])
			{
				secondTop = firstTop;
				firstTop = a[i];
				
			}
		}
		
		System.out.println("1st Top :- " + firstTop);
		System.out.println("2nd Top :- " + secondTop);
	}
	
	
}
