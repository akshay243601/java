package com.akshay.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/***
 *
 * https://leetcode.com/problems/permutations-ii/
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * *****/
public class Permutation_WithArrayWithDuplicateValues {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        permute(nums, 0, nums.length-1, result);
        return new ArrayList<List<Integer>>(result);
    }

    public void permute(int[] nums, int l, int r, Set<List<Integer>> result) {
        if(l == r) {
            List<Integer> ar = new ArrayList<>();
            for(int i : nums) {
                ar.add(i);
            }

            //Its a set. So it will contains only on usique list of interger's list
            result.add(ar);
        }

        for(int i = l; i <= r; i++) {
            swap(nums, i, l);
            permute(nums, l+1, r, result);
            swap(nums, i, l);
        }
    }


    public void swap(int[] nums, int l, int r) {
        if(l == r)
            return;
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


}
