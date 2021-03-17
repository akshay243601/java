package com.akshay.tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
 *
 * This is different from sum sub tree. The ans.
 *
 *                  10
 *           4                3
 *       -1     -3       -10       5
 *       Ans. :  4 + 10 + 3 + 5 = 22
 *
 *
 *                    10
 *            4                 3
 *       1        3         10       5
 *      Ans. :  3 + 4 + 10 + 3 + 10 = 30
 *
 * ****/

public class MaxSumPath {
    int pathSum =Integer.MIN_VALUE;
    public int findSum(PathSumTree.TreeNode node) {
        if (node == null)
            return 0;
        int l = findSum(node.left);
        int r = findSum(node.right);

        pathSum = max(pathSum, node.val, l + node.val, r + node.val, l + r + node.val);
        return max(node.val, node.val + l, node.val + r);
    }
    public int maxPathSum(PathSumTree.TreeNode root) {
        findSum(root);
        return pathSum;
    }

    private int max(int... values) {
        int maxValue = values[0];
        for(int v : values) {
            maxValue = Math.max(maxValue, v);
        }
        return maxValue;
    }
}