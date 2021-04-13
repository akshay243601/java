package com.akshay.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	public static int getHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printLevelTreversal(root, getHeight(root));
		
		System.out.println();
		printLevelOrderTraversal(root);

		System.out.println("TOP TO BOTTOM LEVEL ORDER");
		boolean isTopToBottom = true;
		System.out.println(levelOrderWithResponseAsList(root, isTopToBottom));


		System.out.println("BOTTOM TO TOP LEVEL ORDER");
		isTopToBottom = false;
		System.out.println(levelOrderWithResponseAsList(root, isTopToBottom));

	}




	public static List<List<Integer>> levelOrderWithResponseAsList(TreeNode root, boolean isTopToBottom) {
		List<List<Integer>> result = new ArrayList<>();
		if(root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while(!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> levelList = null;
				levelList = new ArrayList<>();
				while(size > 0) {
					TreeNode node = queue.poll();
					levelList.add(node.data);

					if(node.left != null) {
						queue.add(node.left);
					}

					if(node.right != null) {
						queue.add(node.right);
					}
					size--;
				}
				if(isTopToBottom) {
					result.add(levelList);
				} else {
					result.add(0, levelList);
				}
			}
		}
		return result;
	}

}
