package com.akshay.array;

public class CharFrequencyInSequence {

    private static String getCharFrequency(String value){
        StringBuilder sb = new StringBuilder();
        if(value != null && !value.isEmpty()) {
            int currCount = 1;
            char ch = value.charAt(0);
            for(int i = 1; i < value.length(); i++) {
                if(value.charAt(i) == ch) {
                    currCount++;
                } else {
                    sb.append(ch).append(currCount);
                    ch = value.charAt(i);
                    currCount = 1;
                }
            }
            sb.append(ch).append(currCount);
        }
        return sb.toString();
    }

    private static String getStringFromFreqSequence(String value) {
        StringBuilder res = new StringBuilder();
        if(null != value && !value.isEmpty()) {
            int freq = 0;
            char currCh = value.charAt(0);
            for(int i = 1; i < value.length(); i++) {
                if(Character.isDigit(value.charAt(i))) {
                    freq = freq*10 + Integer.parseInt("" + value.charAt(i));
                } else {
                    res.append(prepareFreqString(currCh, freq));
                    currCh = value.charAt(i);
                    freq = 0;
                }
            }
            res.append(prepareFreqString(currCh, freq));
        }
        return res.toString();
    }

    private static String prepareFreqString(char ch, int freq) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq; i++){
            sb.append(ch);
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.println("abcdaabcccde  --> " +  getCharFrequency("abcdaabcccde"));
        System.out.println("abcdaabcccde  --> " +  getStringFromFreqSequence(getCharFrequency("abcdaabcccde")));




        System.out.println("aabcdaabcccde  --> " +  getCharFrequency("aabcdaabcccde"));
        System.out.println("aabcdaabcccde  --> " +  getStringFromFreqSequence(getCharFrequency("aabcdaabcccde")));


        System.out.println("aaaaaa  --> " +  getCharFrequency("aaaaaa"));
        System.out.println("aaaaaa  --> " +  getStringFromFreqSequence(getCharFrequency("aaaaaa")));


    }
}
