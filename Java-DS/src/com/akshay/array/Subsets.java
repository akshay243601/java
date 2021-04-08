package com.akshay.array;

import java.util.*;
/**
 *
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * All the numbers of nums are unique.
 *
 *
 * *******/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        //add the basic one
        result.add(new ArrayList<Integer>());

        subsets(nums, 0, nums.length-1, result);

        return new ArrayList<List<Integer>>(result);
    }

    public void subsets(int[] nums, int l, int r, Set<List<Integer>> result) {
        if(l <= r) {
            List<Integer> ar = new ArrayList<>();
            for(int i = l; i <= r; i++) {
                ar.add(nums[i]);
            }

            //Its for handling cases : [2,3] vs [3,2] --> both should be anything
            Collections.sort(ar);

            // Here its a set So it will not allowed duplicate elements
            result.add(ar);
        }

        for(int i = l; i <= r; i++) {
            swap(nums, i, l);
            subsets(nums, l+1, r, result);
            swap(nums, i, l);
        }
    }


    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Subsets _instance = new Subsets();
        System.out.println(_instance.subsets(new int[] {1, 2, 3}));
    }
}
