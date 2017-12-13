package com.akshay.array;

public class SecondBiggestInArray {

	private static int getSecondBiggest(int[] a) {

		int biggest = Integer.MIN_VALUE;
		int secBiggest = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > biggest) {
				secBiggest = biggest;
				biggest = a[i];
			} else if (a[i] > secBiggest) {
				secBiggest = a[i];
			}
		}

		return secBiggest;
	}

	public static void main(String[] args) {
		System.out.println(getSecondBiggest(new int[] { 1, 4, 6, 2, 10, 32, 14, 19, 39 }));
	}

}
