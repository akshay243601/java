package com.akshay.tries;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * ****/
public class LongestPrefixInArrayOfWord {
    static  Tries root = new Tries('.');

    private static void insert(String word) {
        TriesUtility.insertWord(root, word);
    }


    public static String longestCommonPrefix(String[] words) {
        for(String word : words) {
            if(word == null || word.length() == 0) {
                return word;
            }
            insert(word);
        }

        String longestPrex = "";
        Tries curr = root;
        while(curr != null) {
            if( curr.getChildren().size() == 1) {
                curr = curr.getChildren().entrySet().iterator().next().getValue();
                longestPrex =  longestPrex + curr.getCh();
                if(curr.isEndOfWord()) {
                    return longestPrex;
                }
            } else {
                break;
            }

        }
        return longestPrex;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix( new String[]{"flower","flow","flight"}));

        root = new Tries('.');
        System.out.println(longestCommonPrefix( new String[]{"flower","flow","flowers"}));

        root = new Tries('.');
        System.out.println(longestCommonPrefix( new String[]{"flower1","flower2","flower3"}));

        root = new Tries('.');
        System.out.println(longestCommonPrefix( new String[]{"","flow","flow"}));

        root = new Tries('.');
        System.out.println(longestCommonPrefix( new String[]{"flow","flow","flow"}));

    }
}
