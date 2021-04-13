package com.akshay.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalWithoutRecursion {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);

            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.data);
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(6);
        binaryTree.insert(24);
        binaryTree.insert(19);
        binaryTree.insert(94);
        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(8);


        System.out.println("Using Stack");
        System.out.println(preorderTraversal(binaryTree.root));

        System.out.println("Using Recursion");
        binaryTree.printPreOrderTraverse(binaryTree.root);


    }

}

