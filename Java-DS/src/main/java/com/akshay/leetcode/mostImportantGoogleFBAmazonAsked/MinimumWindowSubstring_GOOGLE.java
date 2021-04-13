package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring : Hard
 * Best Solution : https://www.youtube.com/watch?v=e1HlptlipB0
 *
 *
 * ****/
public class MinimumWindowSubstring_GOOGLE {

    public String minWindow(String s, String t) {
        String result = "";
        if(s == null && t == null) {
            return s;
        }

        if(s == null || t == null) {
            return null;
        }

        if(s.length() < t.length()) {
            return "";
        }

        // Prepare target string char count map
        Map<Character, Integer> targetMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }


        // Prepare terget string char count map
        Map<Character, Integer> stringMap = new HashMap<>();

        int i = -1;
        int j = -1;
        int matchCount = 0;
        while(true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while(i < s.length() - 1 && matchCount < t.length()) {
                i++;
                //acquire char
                char ch = s.charAt(i);
                stringMap.put(ch, stringMap.getOrDefault(ch, 0) + 1);
                if(stringMap.getOrDefault(ch, 0) <= targetMap.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                flag1 = true;
            }

            while(j < i && matchCount == t.length()) {
                String temp = s.substring(j+1, i+1);
                if(result.length() == 0 || temp.length() < result.length()) {
                    result = temp;
                }

                j++;
                char ch = s.charAt(j);
                //Release char
                if(stringMap.getOrDefault(ch, 0) == 1) {
                    stringMap.remove(ch);
                } else {
                    stringMap.put(ch, stringMap.get(ch) - 1);
                }

                if(stringMap.getOrDefault(ch, 0) < targetMap.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                flag2 = true;
            }


            if(!flag1 && !flag2) {
                break;
            }
        }

        return result;
    }

}
