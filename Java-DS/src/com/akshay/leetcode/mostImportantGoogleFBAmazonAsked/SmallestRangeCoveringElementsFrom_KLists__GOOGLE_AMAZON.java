package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/***
 *
 * HARD : Asked in Amazon
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 *
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Example 2:
 *
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 * Example 3:
 *
 * Input: nums = [[10,10],[11,11]]
 * Output: [10,11]
 * Example 4:
 *
 * Input: nums = [[10],[11]]
 * Output: [10,11]
 * Example 5:
 *
 * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
 * Output: [1,7]
 *
 *
 * Constraints:
 *
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] is sorted in non-decreasing order.
 *
 *
 * ****/

/****
 *
 * Time Complexity : O(n*log(k))   k = number of rows, n = max number of element in a row
 *
 *
 * ****/
public class SmallestRangeCoveringElementsFrom_KLists__GOOGLE_AMAZON {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minX = 0;
        int minY = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((i, j) -> nums.get(i).get(next[i]) -  nums.get(j).get(next[j]));
        for(int i = 0; i < nums.size(); i++) {
            minQueue.add(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = minQueue.poll();
                if(minY - minX > max - nums.get(min_i).get(next[min_i])) {
                    minX = nums.get(min_i).get(next[min_i]);
                    minY = max;
                }
                next[min_i]++;
                if(next[min_i] == nums.get(min_i).size()) {
                    flag = false;
                    break;
                }

                minQueue.add(min_i);
                max = Math.max(max, nums.get(min_i).get(next[min_i]));
            }
        }
        return new int[] {minX, minY};
    }

    // Only 1 test case failed.
    public int[] smallestRange1(List<List<Integer>> nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] ptr = new int[nums.size()];
        int k = nums.size();
        int n = nums.get(0).size();
        int minIndex = 0;
        int maxIndex = 0;
        int shortRange = Integer.MAX_VALUE;
        int finalMin = Integer.MAX_VALUE;
        int finalMax = Integer.MIN_VALUE;
        int flag = 0;

        while(true) {

            // for mainting the index of list containing the minimum element
            minIndex = -1;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            flag = 0;
            for(int i = 0; i < k; i++) {

                int currRowIndexSize = nums.get(i).size();

                if(ptr[i] == currRowIndexSize) {
                    flag = 1;
                    break;
                }

                int currRowIndexElement = nums.get(i).get(ptr[i]);
                if(ptr[i] < currRowIndexSize && currRowIndexElement < min) {
                    minIndex = i;
                    min = currRowIndexElement;
                }

                if(ptr[i] < currRowIndexSize && currRowIndexElement > max) {
                    max = currRowIndexElement;
                }
            }

            if(flag == 1) {
                break;
            }


            ptr[minIndex]++;
            int tempRange = Math.abs(max - min);
            if(shortRange > tempRange) {
                shortRange = tempRange;
                finalMin = min;
                finalMax = max;
            }
        }
        return new int[] {finalMin, finalMax};
    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(4,10,15,24,26));
        matrix.add(Arrays.asList(0,9,12,20));
        matrix.add(Arrays.asList(5,18,22,30));

        SmallestRangeCoveringElementsFrom_KLists__GOOGLE_AMAZON _instance = new SmallestRangeCoveringElementsFrom_KLists__GOOGLE_AMAZON();
        int[] response = _instance.smallestRange(matrix);
        System.out.println(response[0] + " " + response[1]);
    }
}
