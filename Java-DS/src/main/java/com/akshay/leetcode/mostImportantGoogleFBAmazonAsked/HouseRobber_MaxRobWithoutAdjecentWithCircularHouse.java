package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/***
 *
 * https://leetcode.com/problems/house-robber-ii/
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 *
 *
 * ***/
public class HouseRobber_MaxRobWithoutAdjecentWithCircularHouse {

    public static int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //As Houses are in circular form So if we rob nth house we can not rob 1st house of we rob n-1th house then we can rob
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    // THis will be same as we solve previous question
    public static int rob(int[] nums, int start, int end) {
        int dp[] = new int[nums.length];


        // Notice here its dp[start] not the dp[0] or dp[1]
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[end];
    }


    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,3,2})); //3
        System.out.println(rob(new int[] {1,2,3,1})); //1+3
        System.out.println(rob(new int[] {2,7,9,3,1})); //9+2

    }
}
