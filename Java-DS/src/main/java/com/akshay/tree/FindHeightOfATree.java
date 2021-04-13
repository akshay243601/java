package com.akshay.tree;

public class FindHeightOfATree {

	private static int findHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}

	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);
		root.right.right.right.left = new TreeNode(89);
		root.right.right.right.left.right = new TreeNode(90);

		
		System.out.println(findHeight(root));
		
		
	}

}
