package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<String, Integer> romanMap = new HashMap<>();

    private static Integer romanToInteger(String romanNum) {
        prepareRomanMap();
        Integer result = 0;
        for(int i = 0; i < romanNum.length(); i++) {
            String romanStr = "" + romanNum.charAt(i);

            // Special Case Handling
            if(i < romanNum.length() - 1) {
                String checkSpecialCase = "" + romanNum.charAt(i) + romanNum.charAt(i + 1);

                // for 4 -> IV, for 9 -> IX, for 40 -> XL.
                //i.e. For two value if we found in map that means that's the special case.
                if (romanMap.containsKey(checkSpecialCase)) {
                    romanStr = checkSpecialCase;
                    i++;
                    System.out.println(romanStr);
                }
            }
            result = result + romanMap.get(romanStr);
        }
        return result;
    }

    public static void prepareRomanMap() {
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
    }



    public static void main(String[] args) {
        System.out.println(romanToInteger("MMDCCCLXXVIII"));
        System.out.println(romanToInteger("MMDCCCXLIV"));

    }

}
