package com.akshay.sort;

import java.util.Date;
import java.util.Random;

public class MergeSort {

	// this method is ony for dividing the array by half and half
	public static void mergeSort(int[] arr) {

		int length = arr.length;
		if (length > 1) {
			int middle = length / 2;
			int[] left = new int[middle];
			int[] right = new int[length - middle];
			for (int i = 0; i < middle; i++) {
				left[i] = arr[i];
			}

			for (int i = 0; i < length - middle; i++) {
				right[i] = arr[middle + i];
			}

			mergeSort(left);
			mergeSort(right);
			merge(left, right, arr);
		}
	}

	// This method used to sort and merge element
	public static void merge(int[] left, int right[], int[] arr) {

		int i = 0, j = 0, k = 0;

		// Condition 1st :- ----->>>> this will sort by comparing both array
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		// Condition 2:- //Condition 1 will fail atleast either for i or for j
		// Then we need to copy remaining item of either i or j
		while (i < left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[] { -10, 5, 2, -2, -5, -1, 8, 3, 4, 1, 7, 23, 10 };
		mergeSort(arr);

		int[] arr1 = new int[99997];
		for (int i = 0; i < arr1.length; i++) {
			if (i % 2 == 0) {
				arr1[i] = i + 4;
			} else {
				arr1[i] = i - 21;
			}
		}
		System.out.println();
		System.out.println((new Date()));
		mergeSort(arr1);
		System.out.println();
		System.out.println((new Date()));

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + ", ");
		}

	}
}
