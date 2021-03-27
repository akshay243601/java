package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/******
 *
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * 983. Minimum Cost For Tickets
 *
 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * Note:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 *
 *
 * */
public class MinimumCostForTickets {

    //Approach #1
    //Time = [day(days.length-1) - days(0)] //i.e. maxDay - minDay will be the complexity. Or max T(365)
    //Space = maxDay - minDay or max = T(365) + T(n) where n is the length of array
    public static int mincostTicketsWithBestComplexityWithLimitedSpaces(int[] days, int[] costs) {

        // No need to specify the array with 365 days initially. Its better to initialise with endDay - startDay
        int startDay = days[0];
        int endDay = days[days.length-1];
        int daysLen = endDay - startDay + 1;
        int[] dp = new int[daysLen+1];

        //Store days into set to have day exist or not
        Set<Integer> daySet = new HashSet<>();
        for(int d : days) {
            daySet.add(d);
        }


        for(int i = 1; i <= daysLen; i++) {
            dp[i] = dp[i-1];

            // We are comparing the day exist in set or not based on current i value
            //So if i = 1 So it i - 1 + startDay will give correct date which may or may not present in days array
            if(daySet.contains(i - 1 + startDay )) {

                //If a 1-day ticket on day i, dp[i] = dp[i - 1] + cost[0]
                //If a 7-day ticket ending on day i, dp[i] = min(dp[i - 7], dp[i - 6] ... dp[i - 1]) + cost[1]
                //If a 30-day ticket ending on day i, dp[i] = min(dp[i - 30], dp[i - 29] ... dp[i - 1]) + cost[2]

                dp[i] =
                        Math.min(   dp[i-1] + costs[0] , Math.min(
                                dp[Math.max(i-7, 0)] + costs[1],
                                dp[Math.max(i-30, 0)] + costs[2]
                        ));
            }
        }
        return dp[daysLen];
    }

    //Approach #2 : Its  extended version is implemented in Approach #1
    //Time = T(365)
    //Space =  T(365) + T(n) where n is the length of array
    public static  int mincostTicketsWithBestComplexity(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> daySet = new HashSet<>();
        for(int d : days) {
            daySet.add(d);
        }
        int i;
        for(i = days[0]; i <= days[days.length-1]; i++) {
            dp[i] = dp[i-1];
            if(daySet.contains(i)) {

                //If a 1-day ticket on day i, dp[i] = dp[i - 1] + cost[0]
                //If a 7-day ticket ending on day i, dp[i] = min(dp[i - 7], dp[i - 6] ... dp[i - 1]) + cost[1]
                //If a 30-day ticket ending on day i, dp[i] = min(dp[i - 30], dp[i - 29] ... dp[i - 1]) + cost[2]

                dp[i] =
                        Math.min(   dp[i-1] + costs[0] , Math.min(
                                    dp[Math.max(i-7, 0)] + costs[1],   // Here i - 7 < 0 ? 0 : i-7
                                    dp[Math.max(i-30, 0)] + costs[2]   // Here i - 30 < 0 ? 0 : i-30
                                ));
            }
        }
        return dp[i-1];
    }

    //Approach #3 :
    //Time = n(7 + 30) => 37n.  Because for each element its checking for a week in which it check for 7 days and for a month its checking for 30 days.
    //Space : T(n)
    public static int mincostTickets2(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];

        //day : Cost[0]  : max Cost
        //Week : Cost[1] : day > week > month
        //Month : Cost[2] : min cost
        // fill array with max Cost
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i = n-1; i >= 0 ; i--) {
            int d7 = i;
            //days[d7] < days[i] + 7
            // This check is used to check if there is any date which is with in range of currDate + 7 days.
            while(d7 < n && days[d7] < days[i] + 7) {
                ++d7;
            }


            int d30 = i;
            //days[d30] < days[i] + 30
            // This check is used to check if there is any date which is with in range of currDate + 30 days.
            while(d30 < n && days[d30] < days[i] + 30) {
                ++d30;
            }


            // Get Minmum of Current Date with Cost +
            dp[i] = Math.min
                    (
                            costs[0] + dp[i + 1],
                            Math.min(costs[1] + dp[d7],
                                    costs[2] + dp[d30])
                    );

        }

        return dp[0];
    }

    public static void main(String[] args) {

        System.out.println(mincostTicketsWithBestComplexityWithLimitedSpaces(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(mincostTicketsWithBestComplexity(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(mincostTickets2(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));

        System.out.println(mincostTicketsWithBestComplexityWithLimitedSpaces(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
        System.out.println(mincostTicketsWithBestComplexity(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
        System.out.println(mincostTickets2(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));

    }
}
