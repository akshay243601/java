package com.akshay.leetcode;

/*
https://leetcode.com/problems/get-equal-substrings-within-budget/

You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
You are also given an integer maxCost.
Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
If there is no substring from s that can be changed to its corresponding substring from t, return 0.

Example 1:
Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", maxCost = 3
Output: 1
Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", maxCost = 0
Output: 1
Explanation: You can't make any change, so the maximum length is 1.
* */

public class GetEqualSubstringsWithinBudget {
    public static int equalSubstring(String s, String t, int maxCost) {
        if(s == null || t == null || s.length() != t.length()) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int currTotal = 0;
        int res = 0;

        // Start search from 0th index
        for(end = 0; end < s.length(); end++) {

            char charS = s.charAt(end);
            char charT = t.charAt(end);
            int diff = Math.abs(charS - charT);
            currTotal+=diff;


            // If we found the currTotal cost till ith index then
            // we will increase the count and decrease the cost at start index
            while(start <= end && currTotal > maxCost) {
                charS = s.charAt(start);
                charT = t.charAt(start);

                // Here we are decreasing the cost present at start index
                currTotal-=Math.abs(charS - charT);

                //increasing the start index from 0 to +1
                start++;
            }


            int windowLen = end - start + 1;

            //Compare the string length to get the max length sub string
            res = Math.max(res, windowLen);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

}