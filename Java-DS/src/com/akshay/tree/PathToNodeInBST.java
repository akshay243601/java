package com.akshay.tree;

public class PathToNodeInBST {

	static String path = "";
	static TreeNode root1 = null;
	static boolean isPath = false;

	private static void pathToNode(TreeNode node, int nodeValue) {

		if (node != null) {

			if (node.data == nodeValue || isPath) {
				isPath = true;
				path = path + " --> " + node.data;
				return;
			}

			path = path + " --> " + node.data;
			if (node.data > nodeValue) {
				pathToNode(node.left, nodeValue);
			} else {
				pathToNode(node.right, nodeValue);
			}

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(19);

		root1 = root;
		pathToNode(root, 3);
		System.out.println(path);

		path = "";
		isPath = false;
		pathToNode(root, 5);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 8);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 2);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 6);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 4);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 9);
		System.out.println(path);
		
		path = "";
		isPath = false;
		pathToNode(root, 19);
		System.out.println(path);
	}

}
