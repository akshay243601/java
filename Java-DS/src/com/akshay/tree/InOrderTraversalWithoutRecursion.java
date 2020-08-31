package com.akshay.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalWithoutRecursion {
    public static List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> inOrder = new ArrayList<>();
        if(node != null) {
            Stack<TreeNode> stack = new Stack<>();

            while(node != null || !stack.isEmpty()) {

                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }

                TreeNode temp = stack.pop();
                inOrder.add(temp.data);
                node = temp.right;

            }
        }
        return inOrder;
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
        System.out.println(inorderTraversal(binaryTree.root));

        System.out.println("Using Recursion");
        binaryTree.printInOrderTraverse(binaryTree.root);
    }
}
