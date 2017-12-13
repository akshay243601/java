package com.akshay.coreBasics;

import java.awt.Checkbox;

public class WrapperDemo {
	
	

	
	
	
	
	
	
	
	public static void CheckArray(int[] arr) {
		arr[0] = 10;
	}

	public static void CheckArrayForNull(int[] arr) {
		arr = null;
	}

	
	public static void CheckArrayForNullChange(int[] arr) {
		int brr[] = arr;
		brr = null;
	}
	
	public static void CheckArrayForChange(int[] arr) {
		int brr[] = arr;
		brr[0] = 10;

	}

	public static void main(String argsp[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };

		for (int i : arr) {
			System.out.print(i + " , ");
		}
		System.out.println();
		CheckArray(arr);
		
		for (int i : arr) {
			System.out.print(i + " , ");
		}
		System.out.println();
		CheckArrayForChange(arr);

		for (int i : arr) {
			System.out.print(i + " , ");
		}
		System.out.println();
		CheckArrayForNull(arr);

		for (int i : arr) {
			System.out.print(i + " , ");
		}
		
		System.out.println();
		CheckArrayForNullChange(arr);

		for (int i : arr) {
			System.out.print(i + " , ");
		}

		/*
		 * for (int i : arr) { System.out.println(); } CheckArray(arr);
		 * 
		 * 
		 * for (int i : arr) { System.out.println(); }
		 */

	}
}
