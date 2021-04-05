package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/****
 *
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 *
 *
 * ******/
public class Knapsack_PartitionEqualSubsetSum {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is Odd then two pair is not possible
        if(sum%2 == 1) {
            return false;
        }
        sum = sum/2;
        return canPartitionHelper(nums, sum, 0, new Boolean[sum + 1]);
    }

    public boolean canPartitionHelper(int[] nums, int sum, int i, Boolean[] cache) {

        if(sum == 0) {
            return true;
        }

        //if sum is negative then no need to check it should be false only.
        if(i >= nums.length || sum < 0 ) {
            return false;
        }

        if(cache[sum] != null) {
            return cache[sum];
        }


        // Either pick current element or not picked the current element.
        Boolean result =
                            sum == 0
                        || canPartitionHelper(nums, sum - nums[i], i + 1, cache)
                        || canPartitionHelper(nums, sum, i + 1, cache);

        cache[sum] = result;
        return result;
    }


    public boolean canPartition1(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum%2 == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= 0; i--) {
                if(i - num >= 0) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
}
