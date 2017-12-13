package com.akshay.array;

public class OddIncreseEvenDecreaseOrder {

	public static void main(String[] args) {

		int[] a = { 4, 2, 1, 8, 6, 3, 9, 12, 43 };

		int oddCount = 0;
		int evenCount = 0;

		//Get length of even and odd numbers
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}

		int[] odd = new int[oddCount];
		int[] even = new int[evenCount];
		int oddIndex = 0;
		int evenIndex = 0;

		//Fill up even and odd arrays
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				even[evenIndex] = a[i];
				evenIndex++;
			} else {
				odd[oddIndex] = a[i];
				oddIndex++;
			}
		}

		//sort odd with increasing order
		merge(odd, false);
		
		//sort even with decreasing order
		merge(even, true);

		
		for (int i = 0; i < odd.length; i++) {
			System.out.print(odd[i] + " ");
		}

		for (int i = 0; i < even.length; i++) {
			System.out.print(even[i] + " ");
		}
	}

	public static void merge(int[] a, boolean isAsc) {

		if (a.length > 1) {
			int middle = a.length / 2;
			int[] left = new int[middle];
			int[] right = new int[a.length - middle];

			for (int i = 0; i < left.length; i++) {
				left[i] = a[i];
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = a[middle + i];
			}

			merge(left, isAsc);
			merge(right, isAsc);
			mergeSort(left, right, a, isAsc);
		}
	}

	public static void mergeSort(int[] left, int[] right, int[] a, boolean isAsc) {

		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {

			
			if (isAsc) {
				if (left[i] < right[j]) {
					a[k] = left[i];
					i++;
				} else {
					a[k] = right[j];
					j++;
				}
				k++;
			} else {
				if (left[i] > right[j]) {
					a[k] = left[i];
					i++;
				} else {
					a[k] = right[j];
					j++;
				}
				k++;
			}
		}

		while (i < left.length) {
			a[k] = left[i];
			k++;
			i++;
		}

		while (j < right.length) {
			a[k] = right[j];
			k++;
			j++;
		}

	}

}
