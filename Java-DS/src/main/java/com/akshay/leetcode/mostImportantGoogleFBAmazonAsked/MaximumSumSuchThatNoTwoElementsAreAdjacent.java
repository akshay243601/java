package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

    public int FindMaxSum(int arr[], int n){
        int[] dp = new int[n];
        if(arr.length == 1)
            return arr[0];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        MaximumSumSuchThatNoTwoElementsAreAdjacent _instance = new MaximumSumSuchThatNoTwoElementsAreAdjacent();
        System.out.println(_instance.FindMaxSum(new int[] {3, 2, 7, 10}, 4));
        System.out.println(_instance.FindMaxSum(new int[] {5, 5, 10, 100, 10, 5}, 6));
        System.out.println(_instance.FindMaxSum(new int[] {1, 2, 3}, 3));
        System.out.println(_instance.FindMaxSum(new int[] {1, 20, 3}, 3));

    }
}
