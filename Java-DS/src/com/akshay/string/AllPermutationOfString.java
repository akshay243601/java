package com.akshay.string;

public class AllPermutationOfString {

	/*
	* n-> Size of String
	*
	* Time Complexity = time to calculate one permutation * total number of permutation
	* Time Complexity = n            *            !n (factorial n)
	* Time Complexity : O(n * !n)
	* */


	public static void permutate(String val, int l, int r) {
		if (l == r) {
			System.out.print(val + " ");
		} else {
			for (int i = l; i<= r; i++) {
				val = swap(val, l, i);
				permutate(val, l + 1, r);
				val = swap(val, l, i);
			}
		}

	}

	public static String swap(String str, int i, int j) {
		char[] chArr = str.toCharArray();
		char temp = chArr[i];
		chArr[i] = chArr[j];
		chArr[j] = temp;
		return String.valueOf(chArr);
	}

	public static void main(String[] args) {
		String val = "ABC";
		permutate(val, 0, val.length() - 1);
	}
}
