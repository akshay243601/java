package com.akshay.tries;

import java.util.HashMap;

public class Tries {

    private Character ch;
    private HashMap<Character, Tries> children;
    private String word;
    private boolean isEndOfWord;

    public Tries() {
        this.children = new HashMap<>();
        isEndOfWord = false;
    }

    public Tries(Character ch) {
        this.children = new HashMap<>();
        isEndOfWord = false;
        this.ch = ch;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public HashMap<Character, Tries> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, Tries> children) {
        this.children = children;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }
}
