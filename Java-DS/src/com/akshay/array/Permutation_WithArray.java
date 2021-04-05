package com.akshay.array;


import java.util.ArrayList;
import java.util.List;

/***
 *
 * https://leetcode.com/problems/permutations/
 *
 *Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 * ******/
public class Permutation_WithArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length-1, result);
        return result;
    }

    public void permute(int[] nums, int l, int r, List<List<Integer>> result) {
        if(l == r) {
            List<Integer> ar = new ArrayList<>();
            for(int i : nums) {
                ar.add(i);
            }
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
