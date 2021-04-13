package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Hard : 128. Longest Consecutive Sequence
 * Company : Atllansian
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * */
public class LongestConsecutiveSequence {

    //T : O(nlog(n) + n).
    public int longestConsecutive(int[] nums) {
        int best = 0;
        Set<Integer> sets = new HashSet<>();

        for(int num : nums) {
            sets.add(num);
        }

        // Check all element of sets
        for(int n : sets) {

            // This will check only on in forward direction element and not the backward one.
            // For n-1 the "best" is already calculated So no need to again calculate the same.
            if(!sets.contains(n-1)) {
                int m = n+1;

                // As we have to calculate consecutive elements So we have to check m+1 elements
                while(sets.contains(m)) {
                    m++;
                }

                best = Math.max(best, m-n);
            }
        }
        return best;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence _instance = new LongestConsecutiveSequence();
        System.out.println(_instance.longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(_instance.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }
}
