package com.akshay.mostImportantGoogleFBAmazonAsked;

import java.util.HashSet;
import java.util.Set;


/***
 * Asked in Google
 *  https://www.youtube.com/watch?v=99Gw7Hezii8
 *
 *  https://www.codertrain.co/next-closest-time
 * ***/
public class NextClosestTimeWithSameDigit {

    //T -> O(no. of time we calculate the time).
    private static String getNextClosestTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        Set<Integer> digits = new HashSet<>();

        // If time = 23:45
        // If hour is : 23
        digits.add(hour/10);  //23/10 -> 2
        digits.add(hour%10);  //23%10 -> 3

        //If minute : 45
        digits.add(minute/10); //45/10 -> 4
        digits.add(minute%10); //45%10 -> 5
        //digits will store all the digits comes from hour and minutes

        int[] nextTime = new int[] {hour, minute};
        nxt(nextTime);
        while(!isValid(digits, nextTime[0], nextTime[1])) {
            nxt(nextTime);
        }
        return getHourInFormat(nextTime[0])+ ":" + nextTime[1];
    }

    // This will change the hour and minutes and update in nextTime array as well.
    private static void nxt(int[] nextTime) {
        int hour = nextTime[0];
        int minute = nextTime[1];

        // Increase a minute by one to get the next minute
        minute++;
        if(minute == 60) {
            minute = 0;
            hour++;
            if(hour == 24) {
                hour = 0;
            }
        }
        nextTime[0] = hour;
        nextTime[1] = minute;
    }

    private static String getHourInFormat(int hour) {
        if(hour >= 0 && hour <= 9) {
            return "0" + hour;
        } else {
            return hour + "";
        }
    }


    private static boolean isValid(Set<Integer> allDigits, int hour, int minute) {

        return
                        allDigits.contains(hour/10) &&
                        allDigits.contains(hour%10) &&
                        allDigits.contains(minute/10) &&
                        allDigits.contains(minute%10);

    }


    public static void main(String[] args) {
        System.out.println(getNextClosestTime("12:59"));
        System.out.println(getNextClosestTime("19:34"));
        System.out.println(getNextClosestTime("23:59"));

    }

}
