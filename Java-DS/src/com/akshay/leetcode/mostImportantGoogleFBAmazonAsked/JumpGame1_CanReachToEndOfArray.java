package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;


/**
 *
 * https://leetcode.com/problems/jump-game/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * ****/

public class JumpGame1_CanReachToEndOfArray {

    //https://www.youtube.com/watch?v=Gg64QXc9K0s
    /***
     * ===============================================================================
     *  NOTE : WE HAVE SEEN MANY PROBLEMS WHICH CAN BE SOLVED USING SAME SOLUTION
     * ===============================================================================
     * 1. Leet Code : 55 | Jump Game  : https://leetcode.com/problems/jump-game/
     * 2. Leet Code : 45 | Jump Game 2 : https://leetcode.com/problems/jump-game-ii/
     * 3. Leet Code : 1326 | Minimum Number of Taps to Open to Water a Garden : https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
     * 4. Leet Code : 1024 | Video Stitching : https://leetcode.com/problems/video-stitching/
     *
     * All These Question are same Only 1 change required i.e. Start Index and End Index calculation
     * Else 95% code is same.
     * **/
    //Time Complexity : O(n)
    public boolean canJumpUsingMinMax(int[] jumps) {
        int min = 0;
        int max = 0;
        int n = jumps.length-1;
        int index = 0;
        while(max < n) {
            for(int i = index; i < jumps.length; i++) {
                int start = i;
                int end = i + jumps[i];


                if(start > min) {
                    break;
                }

                if(start <= min && end > max) {
                    max = end;
                    index = i;
                }
            }
            if(min == max) {
                return false;
            }
            min = max;
        }
        return true;
    }


    public boolean canJumpUsingMinMax1(int[] jumps) {
        int min = 0;
        int max = 0;
        int n = jumps.length-1;
        int index = 0;
        while(max < n) {
            for(int i = index; i < jumps.length; i++) {
                int start = i;
                int end = i + jumps[i];

                if(start <= min && end > max) {
                    max = end;
                    index = i;
                }
            }
            if(min == max) {
                return false;
            }
            min = max;
        }
        return true;
    }



    // Time Complexity : O(n)
    public boolean canJumpToEnd(int[] nums) {
        int reachable = nums[0];
        for(int i = 1; i < nums.length; i++) {

            //This Mean You are not reachable to i So you can't proceed.
            if(i > reachable) {
                return false;
            }


            // if maxReachable is greater then the length of the array that mean we are already crossed the end point
            if(reachable >=  nums.length-1) {
                return true;
            }

            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


    public static void main(String[] args) {
        JumpGame1_CanReachToEndOfArray _instance = new JumpGame1_CanReachToEndOfArray();
        int[] arr =  new int[]{4,2,3,0,3,1,2};
        System.out.println(_instance.canJumpToEnd(arr));


        arr =  new int[]{4,2,3,0,3,1,2};
        System.out.println(_instance.canJumpToEnd(arr));


        arr =  new int[]{3,0,2,1,2};
        System.out.println(_instance.canJumpToEnd(arr));

    }

}
