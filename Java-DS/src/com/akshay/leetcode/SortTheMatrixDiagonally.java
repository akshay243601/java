package com.akshay.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, Queue<Integer>> diagnal = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int diff = i - j;
                if (!diagnal.containsKey(diff)) {
                    diagnal.put(diff, new PriorityQueue<>());
                }
                diagnal.get(diff).add(mat[i][j]);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int diff = i - j;
                mat[i][j] = diagnal.get(diff).poll();
            }
        }

        return mat;
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

        SortTheMatrixDiagonally sortTheMatrixDiagonally = new SortTheMatrixDiagonally();

        int[][] matrix = new int[][]
                {
                        {3, 3, 1, 1},
                        {2, 2, 1, 2},
                        {1, 1, 1, 2}
                };

        sortTheMatrixDiagonally.printArr(sortTheMatrixDiagonally.diagonalSort(matrix));
   }
}
