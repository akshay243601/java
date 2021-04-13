package com.akshay.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 * ***/
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
                size--;
                if(size == 0) {
                    result.add(temp.data);
                }
            }
        }
        return result;
    }

}
