package com.akshay.dynamicProgramming;


/***
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * */

/****
 * ==================================================================
 * Code Is Almost Same for Largest Square vs Count of All Squares
 * ==================================================================
 * 221. Maximal Square | https://leetcode.com/problems/maximal-square/
 * 1277. Count Square Submatrices with All Ones | https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 * BOTH ARE SAME Except  totalSquares
 * *******/
public class CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int totalSquares = 0;

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(matrix[i-1][j-1] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    totalSquares = totalSquares + dp[i][j];
                }
            }
        }

        return totalSquares;
    }
}
