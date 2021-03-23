package com.akshay.mostImportantGoogleFBAmazonAsked;


import java.util.HashMap;
import java.util.Map;

class IntegerToRoman {
    static Map<Integer, String> romanMap = new HashMap<>();

    //#Approach 1
    public static String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        prepareRomanMap();
        return intToRomanHelper(num);
    }

    public static String intToRomanHelper(int num) {
        if(num >= 1000) {
            return generateRomanString(num, 1000);
        } else if(num >= 900) {
            return generateRomanString(num, 900);
        } else if(num >= 500) {
            return generateRomanString(num, 500);
        } else if(num >= 400) {
            return generateRomanString(num, 400);
        } else if(num >= 100) {
            return generateRomanString(num, 100);
        } else if(num >= 90) {
            return generateRomanString(num, 90);
        }else if(num >= 50) {
            return generateRomanString(num, 50);
        }else if(num >= 40) {
            return generateRomanString(num, 40);
        } else if(num >= 10) {
            return generateRomanString(num, 10);
        } else if(num >= 9) {
            return generateRomanString(num, 9);
        } else if(num >= 5) {
            return generateRomanString(num, 5);
        } else if(num >= 4) {
            return generateRomanString(num, 4);
        } else if(num >= 1) {
            return generateStringWithOccurance(romanMap.get(1), num);
        }
        return "";
    }

    public static String generateRomanString(int num, int rangeValue) {
        StringBuilder sb = new StringBuilder("");
        sb
                .append(generateStringWithOccurance(romanMap.get(rangeValue), num/rangeValue))
                .append(intToRomanHelper(num%rangeValue));
        return sb.toString();
    }

    public static String generateStringWithOccurance(String romanVal, int occurance) {
        String res = "";
        if(occurance > 0 && romanVal != null) {
            while(occurance > 0) {
                res = res + romanVal;
                occurance--;
            }
        }
        return res;
    }


    //2955 --> 955
    public static void prepareRomanMap() {
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    //#Approach 2 : Best Approach
    private static String intToRomanWithoutRecurssion(int num) {
        String result = "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < values.length; i++) {
            while (num >= values[i]) {  // if there are 2989 -> for 2000 -> 1000, 1000 [two time for 1000 etc]
                result = result + romanValues[i];
                num = num - values[i];   // decreasing the value
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(2878));
        System.out.println(intToRomanWithoutRecurssion(2878));

        System.out.println(intToRoman(2844));
        System.out.println(intToRomanWithoutRecurssion(2844));


    }

}