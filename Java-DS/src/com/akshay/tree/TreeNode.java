package com.akshay.tree;

public class TreeNode {
	TreeNode left, right;
	int data;

	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"left=" + left +
				", right=" + right +
				", data=" + data +
				'}';
	}
}
