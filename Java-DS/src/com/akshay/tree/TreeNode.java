package com.akshay.tree;

public class TreeNode {
	public TreeNode left, right;
	public int data;

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
