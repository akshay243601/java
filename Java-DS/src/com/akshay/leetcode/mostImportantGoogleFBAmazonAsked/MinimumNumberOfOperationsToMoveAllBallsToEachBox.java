package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/***
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 *
 *
 * Example 1:
 *
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 * Example 2:
 *
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 *
 *
 * */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    // Approach # 2 :
    //T : O(nm) : Where n is length of boxes and m is no. of 1 present in boxes.
    public static int[] minOperations(String boxes) {
        int[] output = new int[boxes.length()];

        int[] oneIndexs = new int[boxes.length()];
        int onesCount = 0;

        //Get no. of 1's position.
        for(int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1') {
                oneIndexs[onesCount] = i;
                onesCount++;
            }
        }

        for(int i = 0; i < boxes.length(); i++) {
            for(int j = 0; j < onesCount; j++) {

                // i-oneIndexs[j] --> oneIndexs[j] is nothing but 1's position
                output[i] += Math.abs(i-oneIndexs[j]);
            }
        }
        return output;
    }


    //T : O(n*n)
    public static int[] minOperationsWithHighComplexity(String boxes) {
        int[] output = new int[boxes.length()];

        for(int i = 0; i < boxes.length(); i++) {
            for(int j = 0; j < boxes.length(); j++) {
                if(boxes.charAt(j) == '1')
                    output[i] = output[i]  + Math.abs(i-j);
            }
        }
        return output;
    }

    private static void printArr(int[] arr) {
        boolean isFirst = true;
        for(int a : arr) {
            if(isFirst) {
                System.out.print(a);
                isFirst = false;
            } else {
                System.out.print(" ," + a);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        printArr(minOperations("110"));
        printArr(minOperationsWithHighComplexity("110"));
        printArr(minOperations("001011"));
        printArr(minOperationsWithHighComplexity("001011"));
    }
}