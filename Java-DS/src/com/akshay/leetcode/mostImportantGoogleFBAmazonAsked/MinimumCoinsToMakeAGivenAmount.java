package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;


/***
 * https://leetcode.com/problems/coin-change/
 * 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 * ***/
public class MinimumCoinsToMakeAGivenAmount {

    public static int coin(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1+ dp[i - coins[j]]);
                } else {
                    // Because we already sort the coin array.
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coin(new int[] {2}, 3));
        System.out.println(coin(new int[] {1, 2, 3, 4, 5}, 15));
        System.out.println(coin(new int[] {1,2,5}, 11));
        System.out.println(coin(new int[] {1}, 0));
        System.out.println(coin(new int[] {1}, 1));
    }
}
