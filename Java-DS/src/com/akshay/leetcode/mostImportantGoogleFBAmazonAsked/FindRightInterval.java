package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Google
 *
 * https://leetcode.com/problems/find-right-interval/
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 *
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 * Example 3:
 *
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 *
 *
 *
 * ****/
public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {

        List<Pair<Pair<Integer, Integer>, Integer>> indexedInterval = new ArrayList<>();

        // Because all the start time is unique.
        for(int i = 0; i < intervals.length; i++) {
            indexedInterval.add(new Pair(new Pair(intervals[i][0], intervals[i][1]), i));
        }

        //each start is unique
        //Here we are using pair and doing sorting of the pair based on its start time only
        Collections.sort(indexedInterval, (a, b) -> a.getKey().getKey() - b.getKey().getKey());

        //To return the response
        int[] result = new int[indexedInterval.size()];


        for(int i = 0; i < indexedInterval.size(); i++) {
            //Using binary search We will check end[j] > startTime[i]
            result[i] = binarySearch(indexedInterval, intervals[i][1]);
        }
        return result;
    }

    private static int binarySearch(List<Pair<Pair<Integer, Integer>, Integer>> indexedInterval, int endTime) {
        int n = indexedInterval.size();

        //if endTime is greater then maxStartTime (lastStartTime) that mean it has no matching
        if(endTime > indexedInterval.get(n-1).getKey().getKey()) {
            return -1;
        }
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int mid = l + (r-l)/2;

            // based on curr StartTime and requested EndTime we will move pointer of left and right
            //The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
            if(indexedInterval.get(mid).getKey().getKey() >= endTime) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return indexedInterval.get(l).getValue();
    }

    private static void printArr(int[] arr) {
        boolean isFirst = true;
        for(int a : arr) {
            if(isFirst) {
                System.out.print(a);
                isFirst = false;
            } else {
                System.out.print(" ," + a);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]
                {
                        {1, 2}
                };
        printArr(findRightInterval(intervals));


        intervals = new int[][]
                {
                        {3, 4},
                        {2, 3},
                        {1, 2}
                };
        printArr(findRightInterval(intervals));


        intervals = new int[][]
                {
                        {1, 4},
                        {2, 3},
                        {3, 4}
                };
        printArr(findRightInterval(intervals));
    }
}
