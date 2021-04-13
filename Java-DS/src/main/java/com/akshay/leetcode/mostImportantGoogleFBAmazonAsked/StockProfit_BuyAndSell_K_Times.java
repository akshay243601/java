package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;


/***
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 *
 *
 * Example 2:
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * ****/
public class StockProfit_BuyAndSell_K_Times {

    public static int maxProfit(int k, int[] prices) {
        if(k < 1 || prices == null || prices.length < 2 ) {
            return 0;
        }

        int dp[][] = new int[k+1][prices.length];
        for(int i = 1; i < k+1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 1; j < prices.length; j++) {
                max = Math.max(max, dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1], max + prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[] {2, 4, 1}));
        System.out.println(maxProfit(2, new int[] {3, 2, 6, 5, 0, 3}));
    }
}
