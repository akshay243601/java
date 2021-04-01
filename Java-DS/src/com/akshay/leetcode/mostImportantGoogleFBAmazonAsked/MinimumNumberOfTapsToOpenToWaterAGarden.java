package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

/****
 *
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 *
 * Best Exlanation : https://www.youtube.com/watch?v=Pk128gC_sdw
 *
 *
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 *
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 *
 * Example 1:
 *
 *
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * Example 2:
 *
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 * Example 3:
 *
 * Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
 * Output: 3
 * Example 4:
 *
 * Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
 * Output: 2
 * Example 5:
 *
 * Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
 * Output: 1
 *
 *
 * ****/
public class MinimumNumberOfTapsToOpenToWaterAGarden {

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
    public int minTaps(int n, int[] ranges) {
        int min = 0;
        int max = 0;
        int tapCount = 0;
        int index = 0;
        while(max < n) {
            for(int i = index; i < ranges.length; i++) {

                int start = i-ranges[i];
                int end = i + ranges[i];

                if(start <= min && end > max) {
                    max = end;
                    index = i;
                }
            }
            if(min == max) {
                return -1;
            }
            min = max;
            tapCount++;
        }
        return tapCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfTapsToOpenToWaterAGarden minimumNumberOfTapsToOpenToWaterAGarden = new MinimumNumberOfTapsToOpenToWaterAGarden();
        int[] waterTaps = new int[] {3,4,1,1,0,0};
        System.out.println(minimumNumberOfTapsToOpenToWaterAGarden.minTaps(5, waterTaps));

        System.out.println(minimumNumberOfTapsToOpenToWaterAGarden.minTaps(10, waterTaps));

    }

}
