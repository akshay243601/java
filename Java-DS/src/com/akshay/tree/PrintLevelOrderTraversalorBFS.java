package com.akshay.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 
  
 */
public class PrintLevelOrderTraversalorBFS {

	
	//Method 1, In this we need to find value of height
	public static void printLevelTreversal(TreeNode root, int height) {
		for (int i = 1; i <= height; i++) {
			printTrevesal(root, i);
			System.out.println();
		}
	}

	public static void printTrevesal(TreeNode node, int level) {
		if (level == 1) {
			System.out.print(node.data + " ");
		} else if (level > 1) {
			printTrevesal(node.left, level - 1);
			printTrevesal(node.right, level - 1);
		}
	}

	// Method 2
	public static void printLevelOrderTraversal(TreeNode node) {

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(node);

		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();

			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		printLevelTreversal(root, 3);
		System.out.println();
		printLevelOrderTraversal(root);
	}

}
