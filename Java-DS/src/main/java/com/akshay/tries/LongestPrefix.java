package com.akshay.tries;

import java.util.HashMap;

/****
 *
 * Given a dictionary of words and an input string,
 * find the longest prefix of the string which is also a word in dictionary.
 *
 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 *
 * ***/
public class LongestPrefix {

    Tries root;
    public LongestPrefix() {
        root = new Tries();
    }

    public void insert(String word) {
        if(word != null && word.length() > 0) {
            Tries curr = root;
            for(char ch : word.toCharArray()) {
                HashMap<Character, Tries> currChilds =  curr.getChildren();
                if(currChilds.containsKey(ch)) {
                    curr = currChilds.get(ch);
                } else {
                    Tries newTries = new Tries(ch);
                    currChilds.put(ch, newTries);
                    curr = newTries;
                }
            }
            curr.setEndOfWord(true);
            curr.setWord(word);
        }
    }

    public String getLongestPrefix(String input) {
        if(input != null && input.length() > 0) {
            Tries curr = root;
            int index = 0;
            for (char ch : input.toCharArray()) {
                HashMap<Character, Tries> currChildren = curr.getChildren();
                if(currChildren.containsKey(ch)) {
                    curr = currChildren.get(ch);
                    index++;
                } else {
                    break;
                }
            }
            return input.substring(0, index);
        }
        return "";
    }

    public String getLongestPrefixWord(String input) {
        if(input != null && input.length() > 0) {
            Tries curr = root;
            String prevMatch = null;
            for (char ch : input.toCharArray()) {
                HashMap<Character, Tries> currChildren = curr.getChildren();
                if(currChildren.containsKey(ch)) {
                    curr = currChildren.get(ch);
                    if(curr.isEndOfWord()) {
                        prevMatch = curr.getWord();
                    }
                } else {
                    break;
                }
            }
            if(prevMatch != null) {
                return prevMatch;
            } else
                return null;
        }
        return "";
    }


    public static void main(String[] args) {
        LongestPrefix longestPrefix = new LongestPrefix();
        longestPrefix.insert("RAM");
        longestPrefix.insert("RAMANDER");
        longestPrefix.insert("RAMESHAWER");
        longestPrefix.insert("RAMESEAWER");
        longestPrefix.insert("RAMA");


        System.out.println(longestPrefix.getLongestPrefix("RAMESEUIE"));
        System.out.println(longestPrefix.getLongestPrefix("TTTT"));
        System.out.println(longestPrefix.getLongestPrefixWord("RAMASEUIE"));

    }
}
