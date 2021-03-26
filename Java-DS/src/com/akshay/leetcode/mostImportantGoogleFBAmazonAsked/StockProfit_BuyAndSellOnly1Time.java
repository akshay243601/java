package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * **********/
public class StockProfit_BuyAndSellOnly1Time {
    //#Approach : 1 BEST
    private int maxProfitWithSingleTransaction(int[] daysPrice) {
        int maxProfit = 0;
        int low = daysPrice[0];

        for(int i = 1; i < daysPrice.length; i++) {

            //Update the least Price
            if(low > daysPrice[i]) {
                low = daysPrice[i];
            }

            //Calculate everytime the profit
            maxProfit = Math.max(maxProfit, daysPrice[i]-low);
        }
        return maxProfit;
    }

    //Approach#2
    public int maxProfit_1(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int low = prices[0];
        int high = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > high) {
                high = prices[i];
            } else {
                max = Math.max(max, high - low);
                if(prices[i] < low) {
                    low = prices[i];
                    high = prices[i];
                }
            }
        }
        max = Math.max(max, high - low);
        return max;
    }

    public static void main(String[] args) {
        StockProfit_BuyAndSellOnly1Time _instance = new StockProfit_BuyAndSellOnly1Time();
        System.out.println(_instance.maxProfitWithSingleTransaction(new int[] {7,1,5,3,6,4}));
        System.out.println(_instance.maxProfitWithSingleTransaction(new int[] {7,6,4,3,1}));
    }
}
