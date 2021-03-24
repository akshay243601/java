package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;


/**
 *
 * https://leetcode.com/problems/jump-game/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * ****/

public class JumpGame1_CanReachToEndOfArray {

    // Time Complexity : O(n)
    public boolean canJumpToEnd(int[] nums) {
        int reachable = nums[0];
        for(int i = 1; i < nums.length; i++) {

            //This Mean You are not reachable to i So you can't proceed.
            if(i > reachable) {
                return false;
            }


            // if maxReachable is greater then the length of the array that mean we are already crossed the end point
            if(reachable >=  nums.length-1) {
                return true;
            }

            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame1_CanReachToEndOfArray _instance = new JumpGame1_CanReachToEndOfArray();
        int[] arr =  new int[]{4,2,3,0,3,1,2};
        System.out.println(_instance.canJumpToEnd(arr));


        arr =  new int[]{4,2,3,0,3,1,2};
        System.out.println(_instance.canJumpToEnd(arr));


        arr =  new int[]{3,0,2,1,2};
        System.out.println(_instance.canJumpToEnd(arr));

    }

}
