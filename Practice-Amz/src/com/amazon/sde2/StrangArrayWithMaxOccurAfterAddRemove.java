package com.amazon.sde2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrangArrayWithMaxOccurAfterAddRemove {

	public static void printMaxOccurAfterAddRemove(int arr[], int val) {

		int max = 0;
		int maxOccur = 0;
		int l = 0;
		while (l < 100) {
			l++;
			int[] temp = arr;
			for (int i = 0; i < arr.length; i++) {
				temp = getModifiedArray(arr, i, val);
				if (temp != null) {
					int maxArr[] = maxOccurance(temp);

					if (maxArr[1] > max) {
						maxOccur = maxArr[0];
						max = maxArr[1];
					}
				}
			}
			if (temp != null) {
				arr = temp;
			}
		}
		System.out.println("Max Occure Element :- " + maxOccur + "  Count :- " + max);
	}

	public static int[] maxOccurance(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int count = 0;
		int maxOccurElement = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				count = map.get(arr[i]) + 1;
				map.put(arr[i], count);
			} else {
				count = 1;
				map.put(arr[i], count);
			}

			if (count > max) {
				max = count;
				maxOccurElement = arr[i];
			}
		}

		return new int[] { maxOccurElement, max };
	}

	public static int[] getModifiedArray(int arr[], int index, int value) {

		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
				temp[i] = arr[i] + value;
			} else {
				if ((arr[i] - value) < 0) {
					return null;
				}
				temp[i] = arr[i] - value;
			}
		}

		return temp;
	}

	public static void main(String[] args) {

		List<String> str = new ArrayList<>();
		str.add("3"); // no. of Test Cases
		str.add("3 1"); // 1st Test Case : Array Size , Val
		str.add("3 1 3"); // Array Values
		str.add("3 1"); // 2nd Test Case : Array Size , Val
		str.add("2 1 2"); // Array Values
		str.add("3 1"); // 3rd Test Case : Array Size , Val
		str.add("4 2 5"); // Array Values

		int noOfTestCases = Integer.parseInt(str.get(0));
		for (int i = 1; i <= noOfTestCases; i++) {
			String indexStr = str.get((2 * i) - 1);
			int arrLen = Integer.parseInt(indexStr.split(" ")[0]);
			int val = Integer.parseInt(indexStr.split(" ")[1]);
			indexStr = str.get((2 * i));
			int[] arrVal = new int[arrLen];
			System.out.println("array Length :- " + arrLen);
			System.out.println(indexStr);
			for (int j = 0; j < arrLen; j++) {
				arrVal[j] = Integer.parseInt(indexStr.split(" ")[j]);
			}
			printMaxOccurAfterAddRemove(arrVal, val);
		}
	}

}
