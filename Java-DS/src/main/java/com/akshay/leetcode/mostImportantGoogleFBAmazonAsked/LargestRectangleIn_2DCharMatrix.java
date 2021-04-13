package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Stack;
/******
 *
 * GOOGLE/AMAZON/FB Important
 * https://leetcode.com/problems/maximal-rectangle/
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 * Input: matrix = []
 * Output: 0
 *
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 * **********/
public class LargestRectangleIn_2DCharMatrix {

    /**
     * Best Explanation
     * https://www.youtube.com/watch?v=g8bSdXCG-lA
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumRectangularSubmatrixOf1s.java
     * ****/
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] temp = new int[matrix[0].length];
        int maxSize = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != '0') {
                    temp[j] = temp[j] + 1;
                } else {
                    temp[j] = 0;
                }
            }
            int rectArea = largestRectangleAreaInHistogram(temp);
            maxSize = Math.max(maxSize, rectArea);
        }
        return maxSize;
    }


    public int largestRectangleAreaInHistogram(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <  heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int temp = 0;
                if(stack.isEmpty()) {
                    temp = heights[top] * i;
                } else {
                    temp = heights[top] * (i - stack.peek() - 1);
                }
                max = Math.max(max, temp);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            int temp = 0;
            if(stack.isEmpty()) {
                temp = heights[top] * i;
            } else {
                temp = heights[top] * (i - stack.peek() - 1);
            }
            max = Math.max(max, temp);
        }

        return max;
    }

    public static void main(String[] args) {

        LargestRectangleIn_2DCharMatrix _instance = new LargestRectangleIn_2DCharMatrix();

        char[][] matrix = new char[][]
                {
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                };
        System.out.println(_instance.maximalRectangle(matrix));



        matrix = new char[][]
                {
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                };
        System.out.println(_instance.maximalRectangle(matrix));


    }


}
