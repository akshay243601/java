package com.akshay.dynamicProgramming;

/***
 * Microsoft [Important]
 * LeetCode : Hard :  https://leetcode.com/problems/regular-expression-matching/
 * Explanation : https://www.youtube.com/watch?v=l3hda49XcDE
 *
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input: s = "mississippi", p = "mis*is*p*."
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 * ******/
public class RegexMatchingUsingDP {


    // NOTE : '*' Matches zero or more of the preceding element.
    // abc --> ab*c* :-> True
    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        //Fill First row. If "*" comes then pick "j-2"th value
        for(int j = 1; j < dp[0].length; j++) {
            if(pChars[j-1] == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }


        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(sChars[i-1] == pChars[j-1] || pChars[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pChars[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    //If "*" comes then pick "j-2"th value
                    // Also check if pattern "j-2"th vale is "." or match with s"i-1"th then also consider dp[i][j] || dp[i-1][j]
                    if(pChars[j-2] == '.' || sChars[i-1] == pChars[j-2]) {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        RegexMatchingUsingDP _instance = new RegexMatchingUsingDP();
        System.out.println(_instance.isMatch("abc", "a*b*c"));
        System.out.println(_instance.isMatch("abc", "a*.*c"));
    }
}
