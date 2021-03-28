package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Stack;


/***
 * Hard
 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * 84. Largest Rectangle in Histogram
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 * ***/
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] a) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < a.length) {
            if(stack.isEmpty() || a[stack.peek()] < a[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int temp = 0;
                if(stack.isEmpty()) {
                    temp = a[top]*i;
                } else {
                    temp = a[top]*(i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, temp);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int temp = 0;
            if(stack.isEmpty()) {
                temp = a[top]*i;
            } else {
                temp = a[top]*(i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, temp);
        }

        return maxArea;
    }


}
