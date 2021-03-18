package com.akshay.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int counter = size;
            List<Integer> levelList = new LinkedList<>();
            while(counter > 0 ) {
                TreeNode tempNode = queue.poll();
                if(tempNode == null)
                    break;

                if(isLeftToRight) {
                    levelList.add(tempNode.data);
                } else {
                    levelList.add(0, tempNode.data);
                }

                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                counter--;
            }
            isLeftToRight = !isLeftToRight;
            if(levelList.size() > 0)
                res.add(levelList);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);


        System.out.println(zigzagLevelOrder(root));

    }
}
