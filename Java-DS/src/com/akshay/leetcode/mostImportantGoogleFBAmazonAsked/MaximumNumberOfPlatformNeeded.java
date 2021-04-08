package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 *
 *
 * *****/
public class MaximumNumberOfPlatformNeeded {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int result=1, neededPlatform = 1, i = 1, j = 0;

        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                neededPlatform++;
                result = Math.max(result, neededPlatform);
                i++;
            } else {
                neededPlatform--;
                j++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(findPlatform(
                new int[]
                {
                        900, 940, 950, 1100, 1500, 1800
                },
                new int[]{
                        910, 1200, 1120, 1130, 1900, 2000
                },6));
    }
}
