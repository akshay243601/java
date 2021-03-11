package com.akshay.dynamicProgramming;


//https://leetcode.com/problems/maximal-square/

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * **/
public class LargestSquareContainingOnly1s {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix =
                {
                        {'1','0','1','0','0' },
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                };
        System.out.println(maximalSquare(matrix));
    }
}
