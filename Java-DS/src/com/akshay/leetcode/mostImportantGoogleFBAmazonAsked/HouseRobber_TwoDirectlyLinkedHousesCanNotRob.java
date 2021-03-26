package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import com.akshay.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber_TwoDirectlyLinkedHousesCanNotRob {

    static Map<TreeNode, Integer> cache = new HashMap<>();

    //TimeComplexity = O(n) As we are using the cache
    public static int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(cache.containsKey(root)) {
            return cache.get(root);
        }

        int val = 0;
        if(root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        cache.put(root, Math.max(root.data + val, rob(root.left) + rob(root.right)));
        return cache.get(root);
    }


    //TimeComplexity = O(2^n)
    public static int robWith2PowerNComlexity(TreeNode root) {

        if(root == null)
            return 0;

        int val = 0;

        //If a root selected then only its grandson can be selected
        if(root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.data + val, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3); //Include
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);    //Include
        root.right.right = new TreeNode(1);  //Include

        System.out.println(rob(root));
        System.out.println(robWith2PowerNComlexity(root));


    }

}
