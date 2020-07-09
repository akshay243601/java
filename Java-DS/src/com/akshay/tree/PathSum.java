package com.akshay.tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, Integer sum) {
        if(root == null) {
            return  false;
        } else if(root.data == sum && (root.left == null && root.right == null)) {
            return true;
        } else if(root.data != sum && (root.left == null && root.right == null)) {
            return false;
        } else if(root.data == sum) {
            return false;
        }
        return hasPathSum1(root, sum);

    }


    public boolean hasPathSum1(TreeNode root, Integer sum) {
        System.out.println((root == null ? "NULL" : root.data) +  " SUM : " + sum);

        if(root == null) {
            return  sum == 0;
        } else if(root.data == sum &&  (root.left == null && root.right == null)) {
            return true;
        }  else if(root.data == sum) {
            return false;
        }
        return hasPathSum1(root.left, sum-root.data) || hasPathSum1(root.right, sum-root.data);
    }
}
