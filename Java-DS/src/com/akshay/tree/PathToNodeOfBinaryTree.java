package com.akshay.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathToNodeOfBinaryTree {

	static List<Integer> path = new ArrayList<>();
	static int pathLength = 0;

	private static boolean getPath(TreeNode node, int nodeValue) {

		if (node == null) {
			return false;
		}

		if (node.data == nodeValue || getPath(node.left, nodeValue) || getPath(node.right, nodeValue)) {
			path.add(node.data);
			pathLength++;
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(9);

		
		getPath(root, 10);
		Collections.reverse(path);
		for (int pathVal : path) {
			System.out.print(pathVal + " ");
		}

		System.out.println("Path Length : " + pathLength);
	}

}
