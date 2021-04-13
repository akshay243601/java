package com.akshay.array;

public class SumOfNeighbourOfAllElements {

    static int sumOfAll(int n, int[][] a, int i, int j) {
        int rowLimit = a.length - 1;
        int columnLimit = a[0].length - 1;
        int sum = 0;

        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, rowLimit); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, columnLimit); y++) {
                if (x != i || y != j) {
                    sum += a[x][y];
                }
            }
        }
        return sum;
    }

    public static void main (String[] args) {
        int[][] arr =
                {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15}
                };

        System.out.println(sumOfAll(0, arr, 3, 4));

    }

}
