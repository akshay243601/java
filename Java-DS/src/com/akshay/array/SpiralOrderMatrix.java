package com.akshay.array;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/submissions/
 *
 * ***/
public class SpiralOrderMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;

        int left = 0;
        int right = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();

        while (true) {
            for (int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            if (top > bottom) break;

            for (int i = top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (left > right) break;

            for (int i = right; i>=left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            if (top > bottom) break;

            for (int i = bottom; i>=top; i--) {
                list.add(matrix[i][left]);
            }
            left++;

            if (left > right) break;
        }

        return list;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };

        System.out.println(spiralOrder(matrix));
    }


}
