package com.akshay.t9Dictionary;


import java.util.LinkedList;
import java.util.List;

/*  MS Interview Question
    Source : https://www.youtube.com/watch?v=imD5XeNaJXA
*/
public class T9Dictionary {
    public static String[] num_chars = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static List<String> getAllWords(String number) {
        LinkedList<String> words = new LinkedList<>();
        if(null == number || number.length() == 0) {
            return words;
        }


        words.add("");

        //Ex: num : "23", So loop will be for {2, 3}
        for(int i = 0; i < number.length(); i++) {

            // ex: 12 , --> for 1 its length only 1 and it will only store in words :-> "a", "b", "c"
            // Once its length is 2 i.e. "12" then it will removed "1" from words and append "a" with "d,e,f" (3)
            while(words.peek().length() == i) {

                //num present in input param "number"  | number.charAt(i)
                int num = Character.getNumericValue(number.charAt(i));  // "2" or "3" number from input param (numbers)

                //for 2 --> {abc} and for 3 --> {def}
                String charsPresentInDictionaryAtNumber = num_chars[num]; // {a,b,c}


                String str = words.remove();

                //{"a", "b", "c"}
                for(char ch : charsPresentInDictionaryAtNumber.toCharArray()) {
                    words.add(str + ch);
                }
            }
        }
        return words;
    }


    public static void main(String[] args) {
        System.out.println(getAllWords("222"));
//        System.out.println(getAllWords("234"));
//        System.out.println(getAllWords("273"));
//        System.out.println(getAllWords("23544"));

    }
}


