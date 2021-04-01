package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;

/**
 *Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 *
 *Assumption  : We reach everytime to end. So no need to focus on if we are not reaching to end
 */
public class JumpGame2_MinJumpToReachToEnd {

    /***
     * https://www.youtube.com/watch?v=Gg64QXc9K0s
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
    public int jumpWithMinMaxApproach(int[] jumps) {
        int min = 0;
        int max = 0;
        int jump = 0;
        int n = jumps.length-1;
        int index = 0;
        while(max < n) {
            // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
            for(int i = index; i < jumps.length; i++) {
                int start = i;
                int end = i + jumps[i];

                if(start > min) {
                    break;
                }

                if(start <= min && end > max) {
                    max = end;
                    index = i; // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
                }
            }
            if(min == max) {
                return -1;
            }
            min = max;
            jump++;
        }
        return jump;
    }

    //Time Complexity : O(n*n)
    public int jumpWithMinMaxApproach1(int[] jumps) {
        int min = 0;
        int max = 0;
        int jump = 0;
        int n = jumps.length-1;
        int index = 0;
        while(max < n) {
            // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
            for(int i = index; i < jumps.length; i++) {
                int start = i;
                int end = i + jumps[i];

                if(start <= min && end > max) {
                    max = end;
                    index = i; // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
                }
            }
            if(min == max) {
                return -1;
            }
            min = max;
            jump++;
        }
        return jump;
    }


    // Approach 1 : Best
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    //https://www.youtube.com/watch?v=cfdwhSmLt3w
    public int jump(int[] nums) {

        if(nums == null || nums.length < 2) {
            return 0;
        }


        int jump = 1;

        int curr_end = nums[0];
        int reachable = nums[0];
        for(int i = 1; i < nums.length; i++) {

            //This Mean You are not reachable to i So you can't proceed.
            if(i > reachable) {
                return -1;
            }

            // if we reach end of index
            if(i ==  nums.length-1) {
                return jump;
            }


            reachable = Math.max(reachable, i + nums[i]);

            // Update jump. if we reach the curr index and change the reachable distance
            if(i == curr_end) {
                jump++;
                curr_end = reachable;
            }
        }
        return jump;
    }


    // Approach # 3
    // Time Complexity : O(n*n)
    // Space Complexity : O(n)
    public int jumpWithComparingWithItsPreviousJumpsUsingDP(int[] nums) {
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(i <= j + nums[j]) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }

        // here we are assuming we are everytime reaching at end.
        if(jumps[nums.length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return jumps[nums.length - 1];
    }


    public static void main(String[] args) {
        JumpGame2_MinJumpToReachToEnd _instance = new JumpGame2_MinJumpToReachToEnd();
        int[] arr =  new int[]{2,3,1,1,4};
        System.out.println(_instance.jump(arr));
        System.out.println(_instance.jumpWithMinMaxApproach(arr));
        System.out.println(_instance.jumpWithComparingWithItsPreviousJumpsUsingDP(arr));


        arr =  new int[]{2,3,0,1,4};
        System.out.println(_instance.jump(arr));
        System.out.println(_instance.jumpWithMinMaxApproach(arr));
        System.out.println(_instance.jumpWithComparingWithItsPreviousJumpsUsingDP(arr));

        arr =  new int[]{3,2,1,0,4};
        System.out.println(_instance.jump(arr));
        System.out.println(_instance.jumpWithMinMaxApproach(arr));
        System.out.println(_instance.jumpWithComparingWithItsPreviousJumpsUsingDP(arr));

    }
}
