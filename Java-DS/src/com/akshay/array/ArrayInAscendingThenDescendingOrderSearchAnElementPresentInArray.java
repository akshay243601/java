package com.akshay.array;

public class ArrayInAscendingThenDescendingOrderSearchAnElementPresentInArray {

	public static boolean isPresent(int[] a, int n) {
		boolean isPresent = false;
		int start = 0;
		int end = a.length;
		int middle = 0;
		while (start < end) {
			middle = (start + end) / 2;
			if (a[middle] < a[middle + 1]) {
				start = middle;
			} else {
				end = middle - 1;
			}
		}
		return isPresent;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
