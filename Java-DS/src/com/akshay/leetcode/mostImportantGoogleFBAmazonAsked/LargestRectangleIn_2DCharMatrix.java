package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Stack;

public class LargestRectangleIn_2DCharMatrix {

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] temp = new int[matrix[0].length];
        int maxSize = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != '0') {
                    temp[j] += 1;
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
