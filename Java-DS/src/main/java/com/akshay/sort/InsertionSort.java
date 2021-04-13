package com.akshay.sort;

public class InsertionSort {

	public static void bubbleSort(int[] array) {
		for (int i = 1; i < array.length; i++) {

			int value = array[i];
			int hole = i;

			while (hole > 0 && array[hole - 1] > value) {
				array[hole] = array[hole - 1];
				hole = hole - 1;
			}
			array[hole] = value;
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 1, 8, 4, 2, 21, 1, 12 };
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",  ");
		}

	}
}
