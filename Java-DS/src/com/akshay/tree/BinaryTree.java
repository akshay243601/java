package com.akshay.tree;

public class BinaryTree {

	TreeNode root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private TreeNode insert(TreeNode node, int value) {
		if (node == null) {
			node = new TreeNode(value);
		} else {
			if (node.right == null)
				node.right = insert(node.right, value);
			else
				node.left = insert(node.left, value);
		}
		return node;
	}

	public boolean search(int value) {
		return search(root, value);
	}

	private boolean search(TreeNode node, int value) {
		if (node == null) {
			return false;
		}
		
		if(node.data == value){
			return true;
		}
		
		if (node.right != null) {
			if (search(node.right, value)) {
				return true;
			}
		}
		if (node.left != null) {
			if (search(node.left, value)) {
				return true;
			}
		}
		return false;
	}
	
	public int getCount(){
		return getCount(root);
	}
	
	private int getCount(TreeNode node){
		if(node == null){
			return 0;
		}
		
		return 1+getCount(node.left) + getCount(node.right);
	}
	
	private void inOrderTraverse(){
		printInOrderTraverse(root);
	}

	private void printInOrderTraverse(TreeNode node) {
	
		if(node == null)
			return;
		
		printInOrderTraverse(node.left);
		
		System.out.print(node.data + " ");
		
		printInOrderTraverse(node.right);

	}

	private void postOrderTraverse(){
		printPostOrderTraverse(root);
	}

	private void printPostOrderTraverse(TreeNode node) {
	
		if(node == null)
			return;
		
		printPostOrderTraverse(node.left);
		printPostOrderTraverse(node.right);
		System.out.print(node.data + " ");
	}
	
	private void preOrderTraverse(){
		printPreOrderTraverse(root);
	}

	private void printPreOrderTraverse(TreeNode node) {
	
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		printPreOrderTraverse(node.left);
		printPreOrderTraverse(node.right);

	}
	
	public void printTree(){
		printTree(root);
	}
	
	private void printTree(TreeNode node){
		if(node == null){
			return;
		}
		
		System.out.println(node.data + " ");
		printTree(node.left);
		printTree(node.right);

	}
	
	public static void main(String args[]) {
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
		
		
		System.out.println("Count is :- " + binaryTree.getCount());
		int searchElement = 10000909;
		System.out.println("Search for element " + searchElement + " is :- " + binaryTree.search(searchElement));
		System.out.println();
		
		
		System.out.println();
		System.out.println("Inorder iS :- ");
		binaryTree.inOrderTraverse();

		System.out.println();
		System.out.println("PreOrder iS :- ");
		binaryTree.preOrderTraverse();

		System.out.println();
		System.out.println("postOrder iS :- ");
		binaryTree.postOrderTraverse();

	}
}
