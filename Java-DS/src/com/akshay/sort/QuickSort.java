package com.akshay.sort;

public class QuickSort {

	private static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int partition = partition(arr, start, end);
			quickSort(arr, start, partition - 1);
			quickSort(arr, partition + 1, end);
		}
	}

	/***
	 * This is used for partitioning in such a way all element which is sorter
	 * then "pivot" appear at left of pivat and other are right side
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int arr[], int start, int end) {

		// pivot elemnet
		int pivot = arr[end];

		int pIndex = start;

		for (int i = start; i <= end; i++) {
			if (arr[i] < pivot) {
				int temp = arr[pIndex];
				arr[pIndex] = arr[i];
				arr[i] = temp;
				pIndex++;
			}
		}

		int temp = arr[end];
		arr[end] = arr[pIndex];
		arr[pIndex] = temp;
		return pIndex;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 4, 100, 8, 4, 7, 2, 7, 10, 15, 12, 6 };
		quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
}
