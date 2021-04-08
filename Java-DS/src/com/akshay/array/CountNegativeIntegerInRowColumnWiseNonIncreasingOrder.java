package com.akshay.array;

public class CountNegativeIntegerInRowColumnWiseNonIncreasingOrder {

    public int countNegatives(int[][] grid) {
        int count = 0;

        int rowLen = grid.length;
        int c = 0;
        int r = grid[0].length-1;

        while(c < rowLen && r >= 0) {
            if(grid[c][r] < 0) {
                r--;
                count = count + rowLen - c;
            } else {
                c++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNegativeIntegerInRowColumnWiseNonIncreasingOrder _instance = new CountNegativeIntegerInRowColumnWiseNonIncreasingOrder();
        System.out.println(_instance.countNegatives(new int[][]
                                    {
                                            {4,3,2,-1},
                                            {3,2,1,-1},
                                            {1,1,-1,-2},
                                            {-1,-1,-2,-3}
                                    }
                                    ));
    }
}
