package com.akshay.string;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/integer-to-english-words/
public class NumberToWordConvert {

    //Approach No. #1 IS START
    Map<Integer, String> map = null;
    private void prepareMap() {
        map = new HashMap<>();
        map.put(0, "");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(100000000, "Billion");
    }

    public String numberToWords(int num) {
        prepareMap();
        int temp = num;
        String out = "";
        if(num == 0) {
            out = " Zero";
        }

        while(temp > 0) {
            int size = String.valueOf(temp).length();
            switch (size) {
                case 1:
                    out = out + " " + map.get(temp);
                    temp = 0;
                    break;

                case 2:
                    out = out + get2Word(temp, map);
                    if(temp <= 20) {
                        temp = 0;
                    } else {
                        temp = temp%10;
                    }
                    break;

                case 3:
                    out = out + getHundred(temp, map);
                    temp = temp%100;
                    break;

                case 4:
                case 5:
                case 6:
                    int x = temp/1000;
                    if(x > 99) {
                        out = out + getHundred(x, map);
                        x = x - 100*(x/100);
                    }
                    if(x > 0) {
                        out = out + get2Word(x, map);
                    }

                    if(x <= 20) {
                        x = 0;
                    } else {
                        x = x%10;
                    }

                    if(x > 0) {
                        out = out + " " +  map.get(x);
                    }

                    out =  out + " " + "Thousand";
                    temp = temp - 1000*(temp/1000);
                    break;

                case 7:
                case 8:
                case 9:

                    x = temp/1000000;
                    if(x > 99) {
                        out = out + getHundred(x, map);
                        x = x - 100*(x/100);
                    }
                    if(x > 0) {
                        out = out + get2Word(x, map);
                    }

                    if(x <= 20) {
                        x = 0;
                    } else {
                        x = x%10;
                    }

                    if(x > 0) {
                        out = out + " " +  map.get(x);
                    }


                    out =  out + " " + "Million";
                    temp = temp - 1000000*(temp/1000000);
                    break;

                case 10:
                case 11:
                case 12:

                    x = temp/1000000000;
                    if(x > 99) {
                        out = out + getHundred(x, map);
                        x = x - 100*(x/100);
                    }
                    if(x > 0) {
                        out = out + get2Word(x, map);
                    }

                    if(x <= 20) {
                        x = 0;
                    } else {
                        x = x%10;
                    }

                    if(x > 0) {
                        out = out + " " +  map.get(x);
                    }


                    out =  out + " " + "Billion";
                    temp = temp - 1000000000*(temp/1000000000);
                    break;

                default:
                    temp = 0;
                    out += " ";

            }

        }

        out = out.substring(1);
        return out;

    }

    private String getHundred(int temp, Map map) {
        int x = temp/100;
        return " " + map.get(x) + " " + "Hundred";
    }


    private  String get2Word(int temp, Map map) {
        String out = "";
        if(temp <= 20) {
            out = out + " " + map.get(temp);
        } else {
            out = out + " " + map.get(10*(temp/10));
        }
        return out;
    }

    //Approach No. #1 IS CLOSED HERE


    //Approach No. #2 IS Start HERE
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000000000) {
            sb.append(helper(num/1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        else if (num >= 1000000) {
            sb.append(helper(num/1000000)).append( " Million ").append(helper(num % 1000000));
        }
        else if (num >= 1000) {
            sb.append(helper(num/1000)).append(" Thousand ").append(helper(num % 1000));
        }
        else if (num >= 100) {
            sb.append(helper(num/100)).append(" Hundred ").append(helper(num % 100));
        }
        else if (num >= 20) {
            sb.append(tens[num/10]).append(" ").append(helper(num % 10));
        }
        else {
            return ones[num];
        }
        return sb.toString().trim();
    }

    public String numberToWordsGOODAPPROACH(int num) {
        if(num == 0)
            return "Zero";
        return helper(num);
    }
    //Approach No. #2 IS CLOSED HERE


    public static void main(String[] args) {
        NumberToWordConvert numberToWordConvert = new NumberToWordConvert();
        System.out.println(numberToWordConvert.numberToWords(23456));
        System.out.println(numberToWordConvert.numberToWordsGOODAPPROACH(23456));


        System.out.println(numberToWordConvert.numberToWords(834784));
        System.out.println(numberToWordConvert.numberToWordsGOODAPPROACH(20));

    }

}
