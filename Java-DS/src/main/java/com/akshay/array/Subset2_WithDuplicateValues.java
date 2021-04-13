package com.akshay.array;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/subsets-ii/
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 *
 * ******/
public class Subset2_WithDuplicateValues {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        //add the basic one
        result.add(new ArrayList<Integer>());

        permute(nums, 0, nums.length-1, result);

        return new ArrayList<List<Integer>>(result);
    }

    public void permute(int[] nums, int l, int r, Set<List<Integer>> result) {
        if(l <= r) {
            List<Integer> ar = new ArrayList<>();
            for(int i = l; i <= r; i++) {
                ar.add(nums[i]);
            }

            //Its for handling cases : [2,3] vs [3,2] --> both should be anything
            Collections.sort(ar);
            result.add(ar);
        }

        for(int i = l; i <= r; i++) {
            swap(nums, i, l);
            permute(nums, l+1, r, result);
            swap(nums, i, l);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
