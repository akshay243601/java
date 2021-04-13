package com.akshay.sort;

public class BubbleSort {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				// Here we are comparing element with previous element.
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 2, 7, 8, 5, 34, 87, 23, 1 };
		bubbleSort(array);
	}
}
