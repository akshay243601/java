package com.akshay.mostImportantGoogleFBAmazonAsked;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Jump Game 3
 * https://leetcode.com/problems/jump-game-iii/submissions/
 *
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 * Example 1:
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * Example 2:
 *Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 *
 * Example 3:
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 * **/

public class JumpGame3_IfCanReachToZeroFromAnyIndex {

    // Approach# 1 Recursive
    // T = O(2^n)
    // Space : O(n)
    public boolean canReachUsingRecursive(int[] arr, int start) {
        return canReachUsingRecursiveHelper(arr, start);
    }

    public boolean canReachUsingRecursiveHelper(int[] arr, int pos) {
        if(pos < 0 || pos >= arr.length) {
            return false;
        }
        //Check Visited Condition
        if(arr[pos] == -1) {
            return false;
        }


        if(arr[pos] == 0) {
            return true;
        }

        int valueAtPos = arr[pos];

        // Marking visited
        arr[pos] = -1;

        boolean canReach = canReachUsingRecursiveHelper(arr, pos - valueAtPos) || canReachUsingRecursiveHelper(arr, pos + valueAtPos);

        // unmark visited
        arr[pos] = valueAtPos;
        return canReach;
    }

    // Approach# 2 BFS
    /**
     * Nice Explanation
     * https://www.youtube.com/watch?v=7Cz91Uj0VCU
     * */
    public boolean canReachUsingBFS(int[] arr, int start) {
        if(arr == null || arr.length < start) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int point = queue.poll();

            // left direction move
            if(point - arr[point] >= 0) {
                if(arr[point - arr[point]] == 0) {
                    //reach to 0
                    return true;
                }

                // This condition required to not to process again the visited index in arr
                if(arr[point - arr[point]] > 0) {
                    queue.add(point - arr[point]);
                }
            }

            //right direction
            if(point + arr[point] < arr.length) {
                if(arr[point + arr[point]] == 0) {
                    //reach to 0
                    return true;
                }

                // This condition required to not to process again the visited index in arr
                if(arr[point + arr[point]] > 0) {
                    queue.add(point + arr[point]);
                }

            }

            // Just to mark it as visited
            arr[point] = -1;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame3_IfCanReachToZeroFromAnyIndex _instance = new JumpGame3_IfCanReachToZeroFromAnyIndex();
        int[] arr =  new int[]{4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(_instance.canReachUsingRecursive(arr, start));
        System.out.println(_instance.canReachUsingBFS(arr, start));


        arr =  new int[]{4,2,3,0,3,1,2};
        start = 0;
        System.out.println(_instance.canReachUsingRecursive(arr, start));
        System.out.println(_instance.canReachUsingBFS(arr, start));


        arr =  new int[]{3,0,2,1,2};
        start = 2;
        System.out.println(_instance.canReachUsingRecursive(arr, start));
        System.out.println(_instance.canReachUsingBFS(arr, start));

    }
}