package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

public class RotateMatrix_Clockwise90Degree_Google {

    public void rotate(int[][] matrix) {
        int N = matrix.length;


        // Swap i, j with j, i
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Swap i, j with i, N-j-1
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N/2; j++) {
                swap(matrix, i, j, i, N-j-1);
            }
        }

    }

    public void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    private void printArr(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateMatrix_Clockwise90Degree_Google _insRotateMatrix_clockwise90Degree_google = new RotateMatrix_Clockwise90Degree_Google();
        int[][] matrix = new int[][]
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        _insRotateMatrix_clockwise90Degree_google.rotate(matrix);
        _insRotateMatrix_clockwise90Degree_google.printArr(matrix);
    }

}
