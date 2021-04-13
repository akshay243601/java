package com.akshay.array;

import java.util.Arrays;

public class FindClosestPairSumInAArrayToATargetValue {

    public static int[] findClosestPair(int[] arr1, int[] arr2) {
        int[] pair = new int[2];
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minDiff = Integer.MAX_VALUE;
        int tempDiff;
        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {

            // Get the difference If its 0 i.e. Both are equal. This is the closest one
            tempDiff = Math.abs(arr1[index1] - arr2[index2]);
            if(tempDiff == 0) {
                pair[0] = arr1[index1];
                pair[1] = arr2[index2];
                return pair;
            }

            // Update minDiff and Pair if we find any small diff.
            if(minDiff > tempDiff) {
                minDiff = tempDiff;
                pair[0] = arr1[index1];
                pair[1] = arr2[index2];
            }

            // Update index pointers based on value
            if(arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 3, 12, 9};
        int[] arr2 = {11, 14, 8, 6};
        int[] pair = findClosestPair(arr1, arr2);
        System.out.println(pair[0] + " , " + pair[1]);
    }
}
