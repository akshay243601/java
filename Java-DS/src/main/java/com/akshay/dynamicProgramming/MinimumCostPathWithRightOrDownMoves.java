package com.akshay.dynamicProgramming;

public class MinimumCostPathWithRightOrDownMoves {

    // Approach 1 : Recursive Approach
    private static int minCostPath(int[][] matrix, int m, int n) {
        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }else if(m == 0 && n == 0) {
            return matrix[m][n];
        } else
            return matrix[m][n] +
                    Math.min(Math.min(
                        minCostPath(matrix, m, n-1),
                        minCostPath(matrix, m-1, n)),
                        minCostPath(matrix, m-1, n-1)
                    );
    }


    // Approach 2 : Dynamic Programming Approach
    private static int minCostPathViaDP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        //First Row will be filled with first row previous element + cost at current
        //First columns will be filled with first column previous element + cost at current
        // Cost at current Node + Minimum cost of all three from DP

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[0][0] = matrix[i][j];
                }else if(i == 0) {
                    dp[0][j] = matrix[0][j] + dp[0][j-1];
                } else if(j == 0) {
                    dp[i][0] = matrix[i][0] + dp[i-1][0];
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    
    
    public static void main(String[] args)  {
       int[][] matrix =
                {
                        {1,42,33},
                        {4,78,2},
                        {7,8,3}
                };

        System.out.println(minCostPath(matrix, 2, 2));
        System.out.println(minCostPathViaDP(matrix));

    }
}
