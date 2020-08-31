package com.akshay.array;

public class LongestIncreasingSubsequence {

    //APProach 1
    private static int longestIncreasingSubsequenceLength(int[] a) {
        int maxLength = 0;
        for(int i = 0; i < a.length - 1; i++) {
            int max = a[i];
            int tempLen = 1;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] > max) {
                    max = a[j];
                    tempLen++;
                }
                if(i + maxLength > a.length ) {
                    return maxLength;
                }
            }
            if(maxLength < tempLen) {
                maxLength = tempLen;
                return maxLength;
            }
        }
        return maxLength;
    }



    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceLength(new int[] {2, 10, 7, 12, 8, 9, 15, 19, 20, 29}));
    }
}
