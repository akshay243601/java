package com.akshay.tree;

/****
 *
 * https://leetcode.com/problems/path-sum/
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 *
 *
 * Input: root = [1,2], targetSum = 0
 * Output: false
 *
 * **/
public class PathSumTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, 0, targetSum);
    }

    public boolean hasPathSumHelper(TreeNode tree, int remainingSum, int target) {
        if(tree == null)
            return false;

        remainingSum = remainingSum + tree.val;

        if(tree.left == null && tree.right == null) {
            if(remainingSum == target) {
                return true;
            }
        }

        if(hasPathSumHelper(tree.left, remainingSum, target) || hasPathSumHelper(tree.right, remainingSum, target)) {
            return true;
        }
        return false;
    }

}
