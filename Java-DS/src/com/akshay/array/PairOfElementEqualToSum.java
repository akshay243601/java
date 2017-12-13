package com.akshay.array;

public class PairOfElementEqualToSum {

	public static void printPair(int[] a, int sum) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == sum) {
					System.out.println("Pairs are :- " + " [ " + a[i] + " , " + a[j] + " ]");
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] {3,1,6,7,3,6,5,9,34};
		int sum=11;
		printPair(a, sum);
	}
}
