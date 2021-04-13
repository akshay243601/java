package com.akshay.tree;

/***
 * https://leetcode.com/problems/deepest-leaves-sum/
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Example 2:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * ***/


import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class LeetCode_DeepestLeavesSum {


    int res = 0;

    // Approach #1 : Best
    public int deepestLeavesSumUsingRecussion(TreeNode root) {
        int height = getHeight(root);
        getDeepestSum(root, height);
        return res;
    }

    public void getDeepestSum(TreeNode tree, int height) {
        if(tree == null) {
            return;
        }

        if(height == 1) {
            res = res + tree.data;
        }

        getDeepestSum(tree.left, height - 1);
        getDeepestSum(tree.right, height - 1);
    }

    private int getHeight(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
    }

    //Approach #2 : Level Order Traversing and have sum and reset sum at each next level
    public int deepestLeavesSumUsingLevelOrderTraversal(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            while(size > 0) {
                TreeNode node = queue.poll();
                sum = sum + node.data;

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
        }
        return sum;
    }



}
