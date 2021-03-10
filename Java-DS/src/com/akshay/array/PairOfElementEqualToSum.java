package com.akshay.array;

import java.util.HashSet;
import java.util.Set;

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

	public static void printPairUsingSet(int[] a, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= a.length - 1; i++) {
			int diff = sum - a[i];
			if(set.contains(diff)) {
				System.out.println("Pair are : " + a[i] + ", " + diff + " " );
			} else {
				set.add(a[i]);
			}
		}
	}



	public static void main(String[] args) {
		int[] a = new int[] {3,1,6,7,3,6,5,9,4,34};
		int sum=37;
		printPair(a, sum);
		printPairUsingSet(a, sum);
	}
}
