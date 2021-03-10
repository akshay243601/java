package com.akshay.array;


//1,2,5,7,9,10,15,17,19,8,5,4,3,1

public class ArrayInAscendingThenDescendingOrderSearchAnElementPresentInArray {

	public static int getPeakElementIndex(int[] a) {
		int l = 0;
		int r = a.length-1;
		int middle = 0;

		int highElemntIndex = 0;
		while (l < r) {
			middle = l + (r-l)/2;
			if(a[middle-1] < a[middle] && a[middle] >  a[middle + 1] ) {
				highElemntIndex = middle;
				break;
			}
			if(a[middle+1] > a[middle]) {
				l = middle + 1;
			} else {
				r = middle-1;
			}
		}
		System.out.println("High Index : " + highElemntIndex);
		return highElemntIndex;
	}

	private static int findElementInArray(int[] arr, int t) {
		int index = -1;
		int highIndex = getPeakElementIndex(arr);
		index = findElement(arr, 0, highIndex, t,true);
		if(index != -1) {
			return index;
		}
		index = findElement(arr, highIndex, arr.length-1, t, false);
		return index;
	}

	private static int findElement(int[] arr, int l, int r, int t,  boolean isAsc) {
		while(l <= r) {
			int m = l + (r-l)/2;
			if(arr[m] == t) {
				return m;
			}
			if(isAsc) {
				if(arr[m] > t) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				if(arr[m] > t) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] ar = {5,6,7,7,9,10,15,17,19,8,5,4,3,1};
		int target = 5;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 6;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 7;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 9;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 10;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 15;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 17;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 19;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));


		target = 8;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 5;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 4;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 3;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 1;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

		target = 1000;
		System.out.println("Find Element  " + target + " at Index : " + findElementInArray(ar, target));

	}

}
