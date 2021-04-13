package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * Leet code: 139. Word Break
 * Google/Amazon
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 * ******/
public class WordBreak_IsStringCanBeSegmenedWithSpacesInWords {

    public static boolean stringCanBeSegmented(String s, List<String> words) {
        return stringCanBeSegmentedHelper(s, words, new HashMap<String, Boolean>());
    }

    //All the strings of wordDict are unique
    public static boolean stringCanBeSegmentedHelper(String s, List<String> words, Map<String, Boolean> cache) {
        if(cache.containsKey(s)) {
            return cache.get(s);
        }

        boolean result = false;
        if(s.length() == 0) {
            return true;
        }

        for(String word : words) {
            if(s.startsWith(word)) {

                //if s = abcdefgh, word = abc, then we need to check "defgh" with same function
                //subStringToCheck = "defgh"
                String subStringToCheck = s.substring(word.length());
                result = stringCanBeSegmentedHelper(subStringToCheck, words, cache);
                // if result == false, then check for another word.
                if(result == true) {
                    //return true;
                    break;
                }
            }
        }
        cache.put(s, result);
        return result;
    }



    public static void main(String[] args) {
        System.out.println(stringCanBeSegmented("leetcode", Arrays.asList("leet","code","lee","tco")));
        System.out.println(stringCanBeSegmented("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
