package com.akshay.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 *
 *
 * ******/
public class StringExistInBigStringUsingKMPAlgo {

    // #Approach 1 : Using KMP
    public static int findStrIndexUsingKMP(String big, String small) {
        if(small.length() == 0)
            return 0;
        if(small.length() > big.length())
            return -1;

        int[] pattern = buildPattern(small);
        return findStrIndexUsingKMP(big, small, pattern);
    }

    private static int[] buildPattern(String small) {
        int[] pattern = new int[small.length()];
        int i = 1;
        int j = 0;
        Arrays.fill(pattern, -1);
        while(i < small.length()) {
            if(small.charAt(i) == small.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if(j > 0) {
                j = pattern[j-1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

    private static int findStrIndexUsingKMP(String big, String small, int[] pattern) {
        int i = 0;
        int j = 0;
        while(i + small.length() - j <= big.length()) {
            if(big.charAt(i) == small.charAt(j)) {
                if(j == small.length() - 1) {
                    return i-j;
                }
                i++;
                j++;
            } else if(j > 0) {
                j = pattern[j-1] + 1;
            } else {
                i++;
            }
        }
        return -1;
    }

    // #Approach 2 : Without KMP
    public static int findStrIndex(String big, String small) {
        if(small.length() == 0)
            return 0;
        if(small.length() > big.length())
            return -1;

        for(int i = 0; i <= big.length() - small.length(); i++) {
            if(big.charAt(i) == small.charAt(0)) {
                for (int j = 0; j < small.length(); j++) {
                    if(big.charAt(i + j) != small.charAt(j)) {
                        break;
                    } else if(j == small.length() - 1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findStrIndexUsingKMP("abcfabcdabcfabcdabcabcdeghijkabcfabcdabcfababcfabcdabcfabcdabcabcdef", "abcfabcdabcfabcdabcabcdef"));
        System.out.println(findStrIndex("abcfabcdabcfabcdabcabcdeghijkabcfabcdabcfababcfabcdabcfabcdabcabcdef", "abcfabcdabcfabcdabcabcdef"));
    }
}
