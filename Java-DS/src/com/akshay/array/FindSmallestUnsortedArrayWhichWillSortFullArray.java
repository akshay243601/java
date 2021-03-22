package com.akshay.array;

/*
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
 */

public class FindSmallestUnsortedArrayWhichWillSortFullArray {

	public static void getSmallestUnsortedSubArray(int[] a) {
		int startIndex = 0;
		int endIndex = a.length - 1;

		//find minimum index which is start index from left
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				startIndex = i;
				break;
			}
		}

		for (int i = a.length - 1; i >= 1; i--) {
			if (a[i] < a[i - 1]) {
				endIndex = i;
				break;
			}
		}

		int minIndex = startIndex;
		int maxIndex = endIndex;
		int min = a[startIndex];
		int max = a[endIndex];
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (min > a[i]) {
				min = a[i];
			}
			if (max < a[i]) {
				max = a[i];
			}
		}

		for (int i = 0; i < startIndex; i++) {
			if (min < a[i]) {
				minIndex = i;
				break;
			}
		}

		for (int i = a.length-1; i >= endIndex; i--) {
			if (max > a[i]) {
				maxIndex = i;
				break;
			}
		}

		for (int i = minIndex; i <= maxIndex; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String args[]) {
		int[] a = { 1, 4, 7, 3, 10, 48, 17, 26, 30, 30, 50, 65 };
		getSmallestUnsortedSubArray(a);
	}
}
