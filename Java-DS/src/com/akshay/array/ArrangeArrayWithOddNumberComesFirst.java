package com.akshay.array;

public class ArrangeArrayWithOddNumberComesFirst {

	public static int[] rearrangeArrayWithOddComesFirst(int arr[]) {

		int lastIndexOfOddNumber = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				int temp = arr[i];
				arr[i] = arr[lastIndexOfOddNumber + 1];
				arr[lastIndexOfOddNumber + 1] = temp;
				lastIndexOfOddNumber++;
			}
		}
		return arr;
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 10, 4, 6, 7, 5, 3, 2, 4, 17, 8, 9, 124, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		rearrangeArrayWithOddComesFirst(arr);
		System.out.println(arr.toString());
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		StringBuilder platforms = new StringBuilder("IPTV|iPOV|iops|");
	
		if(platforms.lastIndexOf("|") == platforms.length()-1) {
			platforms.deleteCharAt(platforms.lastIndexOf("|"));
		}
		System.out.println(platforms.toString());
		
	}
}
