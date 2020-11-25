package practice.t9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T9Dictionary {

    public static String[] num_chars = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    private static List<String> getWordsFromNumbers(String num) {
        LinkedList<String> words = new LinkedList<>();
        words.add("");

        for(int i = 0; i < num.length(); i++) {

            char[] chArr = num_chars[Character.getNumericValue(num.charAt(i))].toCharArray();


            while (words.peek().length() == i) {
                String str = words.remove();
                for (char ch : chArr) {
                    words.add(str + ch);
                }
            }
        }

        return words;
    }

    public static void main(String[] args) {
        System.out.println(getWordsFromNumbers("222"));

    }
}
