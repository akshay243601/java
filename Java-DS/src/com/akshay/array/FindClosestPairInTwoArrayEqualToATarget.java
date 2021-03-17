package com.akshay.array;

import java.util.Arrays;


public class FindClosestPairInTwoArrayEqualToATarget {

    public static int[] findClosestPair(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int tempDiff = 0;
        int pair[] = new int[2];
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if(targetSum == sum) {
                pair[0] = arr[l];
                pair[1] = arr[r];
                return pair;
            }
            tempDiff = Math.abs(targetSum - sum);
            if(tempDiff < minDiff) {
                pair[0] = arr[l];
                pair[1] = arr[r];
                minDiff = tempDiff;
            }

            if(sum > targetSum) {
                r--;
            } else {
                l++;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 12, 9};
        int[] pair = findClosestPair(arr, 8);
        System.out.println(pair[0] + " , " + pair[1]);
    }


}
