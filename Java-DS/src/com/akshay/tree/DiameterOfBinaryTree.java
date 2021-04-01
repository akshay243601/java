package com.akshay.tree;
/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 * ***/
public class DiameterOfBinaryTree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    public int diameterOfBinaryTreeHelper(TreeNode tree) {
        if(tree == null)
            return 0;

        int leftDepth =  diameterOfBinaryTreeHelper(tree.left);
        int rightDepth =  diameterOfBinaryTreeHelper(tree.right);

        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(9);


        DiameterOfBinaryTree _instance = new DiameterOfBinaryTree();
        System.out.println(_instance.diameterOfBinaryTree(root));
    }
}
