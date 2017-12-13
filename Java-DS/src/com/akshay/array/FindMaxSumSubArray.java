package com.akshay.array;

class SumSubArray {
	int start;
	int end;
	int max_sum;
}

public class FindMaxSumSubArray {

	private static SumSubArray getMaxSumSubArray(int[] arr) {
		SumSubArray result = new SumSubArray();
		result.start = 0;
		result.end = 0;
		result.max_sum = Integer.MIN_VALUE;
		int tempsum = 0;

		boolean isStartIncrease = false;
		for (int i = 0; i < arr.length; i++) {
			tempsum = tempsum + arr[i];
			if (tempsum > result.max_sum) {
				result.max_sum = tempsum;
				result.end = i;
				if (isStartIncrease) {
					result.start = i;
					isStartIncrease = false;
				}
			}
			if (tempsum < 0) {
				isStartIncrease = true;
				tempsum = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] { 3, 2, -10, -40, -30, -50, -100 };
		SumSubArray result = getMaxSumSubArray(arr);

		for (int i = result.start; i <= result.end; i++) {
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		System.out.println("Sum is :- " + result.max_sum);
		System.out.println("start index :- " + result.start);
		System.out.println("End Index :- " + result.end);
	}
}
