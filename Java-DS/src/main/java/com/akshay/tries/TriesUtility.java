package com.akshay.tries;

import java.util.HashMap;

public class TriesUtility {

    public static void insertWord(Tries root, String word) {
        Tries curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            HashMap<Character, Tries> children = curr.getChildren();
            if(!children.containsKey(ch)) {
                Tries newTries = new Tries(ch);
                children.put(ch, newTries);
            }
            curr = children.get(ch);
        }
        curr.setEndOfWord(true);
        curr.setWord(word);
    }
}
