package com.akshay.array;

public class ArrayPrintInClockwiseDirection {

	public static void printArrayInClockwiseDirection() {

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int m = 4, n = 4;
		int temp = m * n - 1, i = 0, j = 0, k = 0;
		int iSub = 0;
		int jSub = 0;
		for (int s = 0; s < m - 1; s++) {
			while (temp >= 0) {
				temp--;

				if (j >= m - s - 1) {
					iSub = 1;
					jSub = 0;
				} else if (i >= m - s - 1) {
					jSub = 1;
					iSub = 0;
				}

				if (j == s) {
					iSub = 1;
					jSub = 0;
				}
				if (i == s) {
					iSub = 0;
					jSub = 1;
				}

				i = i + iSub;
				j = j + jSub;
				System.out.println(arr[i][j]);
			}
		}

	}

	public static void main(String args[]) {

		printArrayInClockwiseDirection();
	}
}
