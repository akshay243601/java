package com.akshay.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                result.add(0, temp.data);
                if(temp.left != null) {
                    stack.push(temp.left);
                }
                if(temp.right != null) {
                    stack.push(temp.right);
                }
            }
        }
        return result;
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
        System.out.println(postorderTraversal(binaryTree.root));

        System.out.println("Using Recursion");
        binaryTree.printPostOrderTraverse(binaryTree.root);


    }


}
