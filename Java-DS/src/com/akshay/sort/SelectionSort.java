package com.akshay.sort;

public class SelectionSort {

	public static void selectionSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;

			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					minIndex = j;
					min = a[j];
				}
			}
			a[minIndex] = a[i];
			a[i] = min;

			System.out.print(a[i] + "  ");

		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 1, 7, 5, 8, 5, 23, 54, 76 };
		selectionSort(a);
	}
}
