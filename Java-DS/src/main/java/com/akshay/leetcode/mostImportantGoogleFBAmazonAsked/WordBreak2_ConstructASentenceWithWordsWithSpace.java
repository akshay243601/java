package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/****
 *
 * 140. Word Break II
 * Hard
 *
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 *  Example 2:
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 * ******/
public class WordBreak2_ConstructASentenceWithWordsWithSpace {

    /*
    * Explanation
    * https://www.youtube.com/watch?v=uR3RElKnrkU
    * */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<>());
    }

    public static List<String> wordBreakHelper(String s, List<String> words, HashMap<String, List<String>> cache) {
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new ArrayList<>();
        if(s.length() == 0) {
            result.add("");
            return result;
        }

        for(String word : words) {
            if(s.startsWith(word)) {
                String subStringToCheck = s.substring(word.length());
                List<String> subStrings = wordBreakHelper(subStringToCheck, words, cache);

                for(String subString : subStrings) {
                    String optionalSpace = subString.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace + subString);
                }
            }
        }

        cache.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
    }

}
