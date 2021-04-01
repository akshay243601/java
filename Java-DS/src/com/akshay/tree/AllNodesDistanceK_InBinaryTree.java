package com.akshay.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Amazon
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 * ***/
public class AllNodesDistanceK_InBinaryTree {

    //https://www.youtube.com/watch?v=B89In5BctFA
    List<TreeNode> path = null;
    //#Approach 1
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        path = new ArrayList<>();
        findPath(root, target);
        List<Integer>  result = new ArrayList<>();
        for(int i = 0; i < path.size(); i++) {
            findKDistanceFromNode(path.get(i), K-i, result, i == 0 ? null : path.get(i-1));
        }
        return result;
    }


    //Blocker is used if we are at left then we have to check right
    public void findKDistanceFromNode(TreeNode node, int dist, List<Integer>  result, TreeNode blocker) {
        if(dist < 0 || node == null || (blocker != null && node == blocker)) {
            return;
        }

        if(dist == 0) {
            result.add(node.data);
        }

        findKDistanceFromNode(node.left, dist-1, result, blocker);
        findKDistanceFromNode(node.right, dist-1, result, blocker);

    }


    public boolean findPath(TreeNode node, TreeNode target) {
        if(node == null)
            return false;

        if(
                node == target ||
                        findPath(node.left, target) ||
                        findPath(node.right, target)) {
            path.add(node);
            return true;
        }

        return false;
    }

    //#Approach 2
    public int printElementsAtKDistance(TreeNode node, TreeNode targetNode, int k) {
        if (node == null || targetNode == null || k < 0) {
            return -1;
        }

        return printElementsAtKDistanceUtil(node, targetNode, k);
    }

    public int printElementsAtKDistanceUtil(TreeNode node, TreeNode targetNode, int k) {
        if(node == null) {
            return -1;
        }

        if(node == targetNode) {
            printNodesAtKDistanceFromParent(node, k);
            return 0;
        }

        int leftDist = printElementsAtKDistanceUtil(node.left, targetNode, k);

        if(leftDist != -1) {
            if(leftDist + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                printNodesAtKDistanceFromParent(node.right, k - 2 - leftDist);
            }

            return leftDist + 1;
        }

        int rightDist = printElementsAtKDistanceUtil(node.right, targetNode, k);

        if(rightDist != -1) {
            if(rightDist + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                printNodesAtKDistanceFromParent(node.left, k - 2 - rightDist);
            }

            return rightDist + 1;
        }

        return -1;
    }

    public void printNodesAtKDistanceFromParent(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data + " ");
        }

        printNodesAtKDistanceFromParent(node.left, k - 1);
        printNodesAtKDistanceFromParent(node.right, k - 1);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(9);


        TreeNode targetNode = root.left.right;
        int k = 2;

        System.out.println(new AllNodesDistanceK_InBinaryTree().distanceK(root, targetNode, k));

    }

}
