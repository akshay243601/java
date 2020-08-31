package com.akshay.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
* */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            double avg = 0.0d;
            int tmpLen = size;
            double sum = 0;

            while(size > 0) {
                TreeNode node = queue.poll();

                sum = sum + node.data;
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

            if(tmpLen > 0) {
                avg = sum/tmpLen;
                res.add(avg);
            }
        }
        return res;
    }

}
