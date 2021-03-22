package com.akshay.snakeLadder;

import java.util.LinkedList;
import java.util.Queue;
/***
 * Google
 * https://leetcode.com/problems/snakes-and-ladders/
 *
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:
 *
 *
 * You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:
 *
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * (This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].
 *
 * Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)
 *
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 *
 * Example 1:
 *
 * Input: [
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * Output: 4
 *
 * Explanation:
 * At the beginning, you start at square 1 [at row 5, column 0].
 * You decide to move to square 2, and must take the ladder to square 15.
 * You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
 * You then decide to move to square 14, and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
 *
 * Note:
 *
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] is between 1 and N*N or is equal to -1.
 * The board square with number 1 has no snake or ladder.
 * The board square with number N*N has no snake or ladder.
 *
 *
 * Good Explanation : https://www.youtube.com/watch?v=zWS2fCJGxmU
 * ***/
public class SnakeLadderGame {

    public int getMinDistanceToReachDestination(int[][] board) {
        int minDis = 0;
        int n = board.length;
        int boardDestination = n*n;
        boolean[][] visited = new boolean[n][n];

        Queue<Integer> boardQueue = new LinkedList<>();

        // As board is started from bottom row and first column;
        visited[n-1][0] = true;

        //board value ideally in snake ladder game is started from 1 not from 0. So board value will be 1, 2, 3, 4 ...... n*n
        boardQueue.add(1);

        while (!boardQueue.isEmpty()) {
            int size = boardQueue.size();
            for(int i = 0; i < size; i++) {
                int currSpotBoard = boardQueue.poll();
                if(currSpotBoard == boardDestination) {
                    return minDis;
                }

                for(int diceVal = 1; diceVal <= 6; diceVal++) {
                    int afterDicSpot = currSpotBoard + diceVal;
                    if(afterDicSpot > boardDestination) {
                        break;
                    }

                    int[] rowColCoordinates = getCoordinates(afterDicSpot, n);
                    int row = rowColCoordinates[0];
                    int col = rowColCoordinates[1];

                    if(visited[row][col] == false) {
                        visited[row][col] = true;
                        if(board[row][col] == -1) {
                            // This mean No ladder and no snake. So we just need to add whatever value comes after dic
                            boardQueue.add(afterDicSpot);
                        } else {
                            // This mean a ladder or a snake present at this position. So Just move to the value which is at board Value at row, col
                            boardQueue.add(board[row][col]);
                        }
                    }
                }
            }
            minDis++;
        }
        return -1;
    }


    /* For understanding of this function.
    * https://www.youtube.com/watch?v=zWS2fCJGxmU
    * */

    // This is very important function to get the row and col from curr index.
    private int[] getCoordinates(int curr, int n) {
        int r = (curr - 1)/n;
        int c = (curr - 1)%n;

        // Rows are calculated from bottom end to up end. In ladder lowest value started from bottom left.
        int row = n - 1 - r;

        //If number of rows are even then col will started from right to left and for even its from left to right.

        /*

        Here rows = 4 (even) So look at column : for index 0, 2
        row : 1 (odd)                 20 19 18 17 16
        row : 2 (even)                11 12 13 14 15
        row : 3 (odd)                 10 9  8  7  6
        row : 4 (even)                1  2  3  4  5

        or

        row : 1 (odd)                  11 12 13 14 15
        row : 2 (even)                 10 9  8  7  6
        row : 3 (odd)                  1  2  3  4  5

        **/

        int col = r%2 == 0 ? c : n - 1 - c;
        return new int[] {row, col};
    }
    /*
    private int[] getCoordinates(int curr, int n) {
        int r = n - (curr - 1)/n -1;
        int c = (curr - 1)%n;

        if(r%2 == n%2) {
            return new int[] {r, n - c - 1};
        } else {
            return new int[] {r, c};
        }
    }
    */
    public static void main(String[] args) {
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame();
        int n = 5;
        int[][] board = new int[][]
                                {
                                        {1},
                                        {2}
                                };

        snakeLadderGame.getMinDistanceToReachDestination(board);
    }
}
