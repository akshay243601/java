package com.akshay.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 *
 * A leaf node is a node with no children.
 *
 * Ex 1 :
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 *
 * Ex: 2 :
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * **/


public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        sumNumbersHelper(root, 0, sums);
        System.out.println(sums);
        int totalSum = 0;
        for(Integer i : sums) {
            totalSum+=i;
        }
        return totalSum;
    }

    public void sumNumbersHelper(TreeNode tree, int remainingSum, List<Integer> sums) {
        if(tree == null)
            return;
        remainingSum = 10*remainingSum + tree.val;
        if(tree.left == null && tree.right == null) {
            sums.add(remainingSum);
        }
        sumNumbersHelper(tree.left, remainingSum, sums);
        sumNumbersHelper(tree.right, remainingSum, sums);
    }
}
