package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/**
 *  518. Coin Change 2 | https://leetcode.com/problems/coin-change-2/
 *  You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Note:
 *
 * You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 * ********/
public class Knapsack_CoinChange2_ToMakeAGivenAmount_NumberOfWays {

  public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;   // Only this is change else code is almost same as change coin
        for(int coin : coins) {
            for(int i = coin; i < amount+1; i++) {
                dp[i] = dp[i] + dp[i-coin];  // Only this is change else code is almost same as change coin
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Knapsack_CoinChange2_ToMakeAGivenAmount_NumberOfWays _instance = new Knapsack_CoinChange2_ToMakeAGivenAmount_NumberOfWays();
        System.out.println(_instance.change(5, new int[] {1, 2, 5}));
    }

}