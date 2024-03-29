package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/**
 * Google
 * https://leetcode.com/problems/battleships-in-a-board/
 * // Best Explanation : https://www.youtube.com/watch?v=wBG6078g1gE
 *
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * 1. You receive a valid board, made of only battleships or empty slots.
 * 2. Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * 3. At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 *
 *
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 *
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 *
 * **/
public class BattleshipsInABoard {
    public static int countBattleships(char[][] board) {
        int battleshipCount = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                //At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
                // This mean if we have [X X . X X] -> this says we have two battleship (not 4)
                // Because condition is two battle are seprated by "." []

                if(i > 0 && board[i-1][j] == 'X') {
                    continue;
                }

                if(j > 0 && board[i][j-1] == 'X') {
                    continue;
                }

                //If all the above conditions false that mean it has 'X' (battleship)
                battleshipCount++;
            }
        }
        return battleshipCount;
    }

    public static int countBattleshipsUsingRecursiveCall(char[][] board) {
        int battleshipCount = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    battleshipCount++;
                    countBattleshipsUsingRecursiveCall(board, i, j);
                }
            }
        }

        return battleshipCount;
    }

    public static void countBattleshipsUsingRecursiveCall(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
            return;
        }

        // Here are we are updating the value to '#' it will not be count the battleship again in calling function : countBattleshipsUsingRecursiveCall
        board[i][j] = '#';

        countBattleshipsUsingRecursiveCall(board, i + 1, j);
        countBattleshipsUsingRecursiveCall(board, i - 1, j);
        countBattleshipsUsingRecursiveCall(board, i, j + 1);
        countBattleshipsUsingRecursiveCall(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {
                        {'X','.','.', 'X'},
                        {'.','.','.', 'X'},
                        {'.','.','.', 'X'}
                };

        System.out.println(countBattleships(board)); //2
        System.out.println(countBattleshipsUsingRecursiveCall(board)); //2


        board = new char[][]
                {
                        {'X','.','.', 'X'},
                        {'.','X','.', 'X'},
                        {'.','X','.', 'X'}
                };
        System.out.println(countBattleships(board)); // 3
        System.out.println(countBattleshipsUsingRecursiveCall(board)); //3


        board = new char[][]
                {
                        {'X','X','.','X','X'}
                };
        System.out.println(countBattleships(board)); // 2
        System.out.println(countBattleshipsUsingRecursiveCall(board)); //2

    }
}
