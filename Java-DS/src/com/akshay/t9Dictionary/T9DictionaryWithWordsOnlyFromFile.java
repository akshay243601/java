package com.akshay.t9Dictionary;

import java.util.*;

// MS Interview Question
// There is a file which Store all the words. We have to find out if we enter any integers digits (eg. 123), it should return the data found in file for this integer(123)
public class T9DictionaryWithWordsOnlyFromFile {

    static List<String> fileWords = new ArrayList<>();
    static Map<Character, Integer> mapping = new HashMap<>();
    static Map<String, TreeSet<String>> dictionary = new HashMap<>();

    static {
        mapping.put('0', 0);
        mapping.put('1', 1);
        mapping.put('a', 2);
        mapping.put('b', 2);
        mapping.put('c', 2);
        mapping.put('d', 3);
        mapping.put('e', 3);
        mapping.put('f', 3);
        mapping.put('g', 4);
        mapping.put('h', 4);
        mapping.put('i', 4);
        mapping.put('j', 5);
        mapping.put('k', 5);
        mapping.put('l', 5);
        mapping.put('m', 6);
        mapping.put('n', 6);
        mapping.put('o', 6);
        mapping.put('p', 7);
        mapping.put('q', 7);
        mapping.put('r', 7);
        mapping.put('s', 7);
        mapping.put('t', 8);
        mapping.put('u', 8);
        mapping.put('v', 8);
        mapping.put('w', 9);
        mapping.put('x', 9);
        mapping.put('y', 9);
        mapping.put('z', 9);

        readDataFromFile();
        prepareDictionary();
    }

    private static void readDataFromFile() {
        fileWords.add("abc");
        fileWords.add("aaa");
        fileWords.add("adc");
        fileWords.add("akshay");
        fileWords.add("gupta");
        fileWords.add("watsapp");
        fileWords.add("facebook");
        fileWords.addAll(Arrays.asList("a", "b", "rocky"));
    }

    private static void prepareDictionary(){
        for(String word : fileWords) {
            addWordIntoDictionary(word);
        }
    }

    private static void addWordIntoDictionary(String word) {
        if(word != null && word.length() > 0) {
            String numStr = "";
            for(int i = 0; i < word.length(); i++) {
                numStr = numStr + mapping.get(word.charAt(i));
            }
            if(!dictionary.containsKey(numStr)) {
                dictionary.put(numStr, new TreeSet<>());
            }
            dictionary.get(numStr).add(word);
        }
    }

    private static Set<String> printTheWords(String number) {
        if(number == null || number.trim().length() == 0) {
            return null;
        }
        return dictionary.get(number);
    }

    public static void main(String[] args) {
        System.out.println(printTheWords("222"));
        System.out.println(printTheWords("2"));
    }
}


