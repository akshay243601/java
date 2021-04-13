package com.akshay.leetcode;
/***
 *
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * */
public class SpiralMatrixII_WithANumberGenerateArrayInCircularForm {

    public static int[][] generateMatrix(int n) {
        System.out.println();
        System.out.println();

        System.out.println("Input : " + n);
        int currValue = 1;
        int l = 0, r = n-1, t = 0, b = n-1;
        int[][] matrix = new int[n][n];
        while(true) {
            for(int i = l; i <= r; i++) {
                matrix[t][i] = currValue++;
            }
            t++;
            if(t > b) {
                break;
            }

            for(int i = t; i <= b; i++) {
                matrix[i][r] = currValue++;
            }
            r--;
            if(l > r) {
                break;
            }


            for(int i = r; i >= l; i--) {
                matrix[b][i] = currValue++;
            }
            b--;
            if(t > b) {
                break;
            }


            for(int i = b; i >= t; i--) {
                matrix[i][l] = currValue++;
            }
            l++;
            if(l > r) {
                break;
            }


        }
        return matrix;
    }

    private static void printArr(int[][] arr) {
        for(int[] row : arr) {
            boolean isFirst = true;
            for(int col : row) {
                if (isFirst) {
                    System.out.print(col);
                    isFirst = false;
                } else {
                    System.out.print(" , " + col);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printArr(generateMatrix(3));

        printArr(generateMatrix(5));

        printArr(generateMatrix(6));

    }
}
