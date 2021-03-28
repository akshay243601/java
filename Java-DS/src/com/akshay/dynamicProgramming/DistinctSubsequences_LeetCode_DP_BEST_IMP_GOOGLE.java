package com.akshay.dynamicProgramming;


/***
 * 115. Distinct Subsequences
 * Google/FB/Amazon : HARD
 * https://leetcode.com/problems/distinct-subsequences/
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 *
 *
 *
 * *******/
public class DistinctSubsequences_LeetCode_DP_BEST_IMP_GOOGLE {

    /***
     * best Explanation: https://www.youtube.com/watch?v=NR9lLQnFjWc
     * */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // here s will move as j ---> columnwise
        // and t will be move columnwise
        //for first row i.e. row = 1.  if s.charAt(i) == t.charAt(0) :->  dp[1][j] = dp[i][j-1] + 1
        // for all other rows : dp[i-1][j-1] + dp[i][j-1]


        int[][] dp = new int[n+1][m+1];
        for(int j = 1; j <= m; j++) {
            if(t.charAt(0) == s.charAt(j-1)) {
                dp[1][j] = 1 + dp[1][j-1];
            } else {
                dp[1][j] = dp[1][j-1];
            }
        }


        for(int i = 2; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));

        s = "babgbag";
        t = "bag";
        System.out.println(numDistinct(s, t));


    }
}
