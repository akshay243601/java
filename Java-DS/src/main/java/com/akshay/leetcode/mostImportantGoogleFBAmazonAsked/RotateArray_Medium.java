package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/rotate-array/
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * ****/
public class RotateArray_Medium {

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length;
        int[] tempArr = new int[k];

        for(int i = 0; i < k; i++) {
            tempArr[i] = nums[n - k + i];
        }

        for(int i = n-1; i >= k; i--) {
            nums[i] = nums[i-k];
        }

        for(int i = 0; i < k; i++) {
            nums[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        RotateArray_Medium _instance = new RotateArray_Medium();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        _instance.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
