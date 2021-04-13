package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/****
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 *
 * *****/

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int islandCount = 0;
        int m = grid.length-1;
        int n = grid[0].length-1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islandCount++;
                    numIslands(grid, m, n, i, j);
                }
            }
        }

        return islandCount;
    }

    public static void numIslands(char[][] grid, int m, int n, int i, int j) {
        if(i < 0 || i > m || j < 0 || j > n || grid[i][j] != '1') {
            return;
        }

        // This will change value of island to "." so that it will not be picked again
        grid[i][j] = '.';

        numIslands(grid, m, n, i-1, j);
        numIslands(grid, m, n, i+1, j);
        numIslands(grid, m, n, i, j-1);
        numIslands(grid, m, n, i, j+1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                };

        System.out.println(numIslands(grid));
    }
}
