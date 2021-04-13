package com.akshay.tree;

public class IsBinaryTreeASumTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(3);

		if (isSumTree(root))
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}

	private static boolean isSumTree(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}

		int lb = sum(node.left);
		int rb = sum(node.right);

		if (lb + rb == node.data && isSumTree(node.left) && isSumTree(node.right)) {
			return true;
		}
		return false;
	}

	private static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return node.data + sum(node.left) + sum(node.right);
	}

}
