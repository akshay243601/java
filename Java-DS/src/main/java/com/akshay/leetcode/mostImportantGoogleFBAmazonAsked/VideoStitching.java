package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/video-stitching/
 * BEST EXPLANATION : https://www.youtube.com/watch?v=Gg64QXc9K0s
 * You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.
 *
 * Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 *
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * Output: 3
 * Explanation:
 * We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 * Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 * Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 * Example 2:
 *
 * Input: clips = [[0,1],[1,2]], T = 5
 * Output: -1
 * Explanation:
 * We can't cover [0,5] with only [0,1] and [1,2].
 * Example 3:
 *
 * Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * Output: 3
 * Explanation:
 * We can take clips [0,4], [4,7], and [6,9].
 * Example 4:
 *
 * Input: clips = [[0,4],[2,8]], T = 5
 * Output: 2
 * Explanation:
 * Notice you can have extra video after the event ends.
 *
 *
 * Constraints:
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 *
 * ****/



public class VideoStitching {

    //https://www.youtube.com/watch?v=Gg64QXc9K0s
    /***
     *
     * ===============================================================================
     *  NOTE : WE HAVE SEEN MANY PROBLEMS WHICH CAN BE SOLVED USING SAME SOLUTION
     * ===============================================================================
     * 1. Leet Code : 55 | Jump Game  : https://leetcode.com/problems/jump-game/
     * 2. Leet Code : 45 | Jump Game 2 : https://leetcode.com/problems/jump-game-ii/
     * 3. Leet Code : 1326 | Minimum Number of Taps to Open to Water a Garden : https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
     * 4. Leet Code : 1024 | Video Stitching : https://leetcode.com/problems/video-stitching/
     *
     *
     * For all the mentioned solution if array's start and end is sorted then complexity will be O(n) only. and if we are doing sorting then complexity will be O(nLog(n) + n) here nLog(n) for sorting the array based on start range
     *
     *
     * All These Question are same Only 1 change required i.e. Start Index and End Index calculation
     * Else 95% code is same. and Solution is 100% faster then other solution submitted on LeetCode
     * **/
    //Time Complexity : O(nlog(n))
    public int videoStitching(int[][] clips, int T) {
        int min = 0;
        int max = 0;
        int count = 0;
        int index = 0;

        // Array Sort : Complexity : nlog(n)
        Arrays.sort(clips, (a, b) -> (a[0] - b[0]));

        // If arrays is sorted then this while loop will completely run with O(n) time because we are running i = index in for loop as well as we are breaking the loop once we got
        while(max < T) {
            // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
            for(int i = index; i < clips.length; i++) {

                int start = clips[i][0];
                int end = clips[i][1];

                // As array is in sorted format then no need to check future elemnt as all the element must be greater then element
                if(start > min) {
                    break;
                }
                if(start <= min && end > max) {
                    max = end;
                    // No need to start again from 0 so we can have index and no need to start again from 0 in for loop.
                    index = i;
                }
            }
            if(min == max) {
                return -1;
            }
            min = max;
            count++;
        }
        return count;
    }

    // Complexity near by by O(n*n) // Without Sorting
    public int videoStitching1(int[][] clips, int T) {
        int min = 0;
        int max = 0;
        int count = 0;
        while(max < T) {
            for(int i = 0; i < clips.length; i++) {

                int start = clips[i][0];
                int end = clips[i][1];

                if(start <= min && end > max) {
                    max = end;
                }
            }
            if(min == max) {
                return -1;
            }
            min = max;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}
         * 100
         * */
        VideoStitching videoStitching = new VideoStitching();
        int[][] clips = new int[][]
                {
                        {0,2},
                        {4,6},
                        {8,10},
                        {1,9},
                        {1,5},
                        {5,9}
                };
        int T = 10;
        System.out.println(videoStitching.videoStitching(clips, T));

        T = 100;
        System.out.println(videoStitching.videoStitching(clips, T));


    }
}
