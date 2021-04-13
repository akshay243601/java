package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.ArrayList;
import java.util.List;

/***
 * //Google/FB/Amazon
 * https://leetcode.com/problems/insert-interval/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Example 3:
 *
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * Example 4:
 *
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * Example 5:
 *
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 *
 *  Best Explanation : https://www.youtube.com/watch?v=FuLfL_WhUHI
 *
 */

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]
                    {
                            {newInterval[0], newInterval[1]}
                    };
        }
        int n = intervals.length;
        int i = 0;
        List<int[]> response = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        //Step 1:  Add all the interval before the newInterval starttime.
        while(i < n && start > intervals[i][1]){
            response.add(intervals[i]);
            i++;
        }

        //Step 2:  Compare and merge the interval which is started before the end time. As in step 1 we already have the before intervals. So these inteval will be the overlapping one
        int[] mergedInterval = newInterval;
        while(i < n && end >= intervals[i][0]) {
            mergedInterval[0] = Math.min(mergedInterval[0], intervals[i][0]);
            mergedInterval[1] = Math.max(mergedInterval[1], intervals[i][1]);
            i++;
        }
        response.add(mergedInterval);

        //Step 3 : All the remaining intervals
        while(i < n) {
            response.add(intervals[i]);
            i++;
        }
        return response.toArray(new int[response.size()][2]);
    }

    private  void printArr(int[][] arr) {
        boolean isFirst = true;
        for(int[] a : arr) {
            if(isFirst) {
                System.out.print("[" + a[0] + " " + a[1] + "]");
                isFirst = false;
            } else {
                System.out.print(" , [" + a[0] + " " + a[1] + "]");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertInterval _instance = new InsertInterval();

        int[][] intervals = new int[][]
                {
                        {1, 3},
                        {6, 9}
                };
        int[] newInterval = new int[]{2, 5};
        _instance.printArr(_instance.insert(intervals, newInterval));


        intervals = new int[][]
                {
                        {1, 2},
                        {3, 5},
                        {6, 7},
                        {8, 10},
                        {12, 16}
                };
        newInterval = new int[]{4, 8};
        _instance.printArr(_instance.insert(intervals, newInterval));


        intervals = new int[][]
                {
                };
        newInterval = new int[]{5, 7};
        _instance.printArr(_instance.insert(intervals, newInterval));


        intervals = new int[][]
                {
                        {1, 5}
                };
        newInterval = new int[]{2, 3};
        _instance.printArr(_instance.insert(intervals, newInterval));


        intervals = new int[][]
                {
                        {1, 5}
                };
        newInterval = new int[]{2, 7};
        _instance.printArr(_instance.insert(intervals, newInterval));
    }

}
