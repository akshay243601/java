package com.akshay.string;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/generate-parentheses/
 *
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * ****/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        generateParenthesis(output, "", 0, 0, n);
        return output;

    }

    public void generateParenthesis(List<String> output, String str, int open, int close, int n) {
        if(str.length() == 2*n) {
            output.add(str);
            return;
        }

        if(open < n) {
            generateParenthesis(output, str+"(", open+1, close, n);
        }
        // Here close is less then Open
        if(close < open) {
            generateParenthesis(output, str+")", open, close+1, n);
        }

    }
}
