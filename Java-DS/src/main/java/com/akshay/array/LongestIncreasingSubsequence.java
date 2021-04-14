package com.akshay.array;

public class LongestIncreasingSubsequence {


    // Complexity :
    // Time : O(n*n)
    //Space : O(n)  : A new array we are using
    //https://leetcode.com/problems/longest-increasing-subsequence/submissions/
    private static int longestIncreasingSubsequenceLength(int[] nums) {
        int lis[] = new int[nums.length];
        int max = 0;

        // Initially everything should be 1
        for(int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                // Check all the element previous to current element should be less, then increase the lis
                if(nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceLength(new int[] {2, 10, 7, 12, 8, 9, 15, 19, 20, 29}));

        System.out.println(longestIncreasingSubsequenceLength(new int[] {10, 22, 9, 33, 21, 50, 41, 60}));


        System.out.println(longestIncreasingSubsequenceLength(new int[] {3, 10, 2, 1, 20}));
        System.out.println(longestIncreasingSubsequenceLength(new int[] {50, 3, 10, 7, 40, 80}));

    }
}
