package com.akshay.dynamicProgramming;

public class CostForEditFrom1WordTo2ndWord {

    private static int minCostOfEditFromWord1ToWord2(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen+1][bLen+1];

        for(int i = 0; i <= a.length(); i++) {
            for(int j = 0; j <= b.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) ;
                    }
                }
            }
        }
        return dp[aLen][bLen];
    }

    public static void main(String[] args) {
        System.out.println(minCostOfEditFromWord1ToWord2("ABCDEFGHI", "ACDEFGHIBXYZ"));
    }
}
