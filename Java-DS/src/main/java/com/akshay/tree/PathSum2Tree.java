package com.akshay.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum 2
 * https://leetcode.com/problems/path-sum-ii/
 *
 *Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Example 2:
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 * *********/
public class PathSum2Tree {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum, new ArrayList<>());
        return res;
    }

    public boolean hasPathSum(TreeNode root, Integer sum, List<Integer> result) {
        return hasPathSumhelper(root, sum, 0, result);
    }
    public boolean hasPathSumhelper(TreeNode root, int target, int currSum, List<Integer> result) {
        if(root == null) {
            return  false;
        }
        currSum += root.data;

        if(root.left == null && root.right == null && currSum == target) {
            result.add(root.data);
            res.add(new ArrayList<Integer>(result));
            return true;
        }

        if(hasPathSumhelper(root.left,target,  currSum, result) || hasPathSumhelper(root.right, target, currSum, result)) {
            result.add(root.data);
            return true;
        }
        return false;
    }

}
