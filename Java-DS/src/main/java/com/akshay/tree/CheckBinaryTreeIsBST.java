package com.akshay.tree;

public class CheckBinaryTreeIsBST {

	TreeNode root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private TreeNode insert(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data);
			return node;
		}

		if (node.right == null) {
			node.right = insert(node.right, data);
		} else {
			node.left = insert(node.left, data);
		}
		return node;
	}

	public boolean isBST(){
		return isBST(root);
	}
	
	public static TreeNode prev = null;
	private boolean isBST(TreeNode node){
		
		if(node == null)
		{
			return true;
		}		
		if(!isBST(node.left)){
			return false;
		}
		
/*		if(node.left != null && node.left.data > node.data ){
			return false;
		}
*/		
		if(prev != null && prev.data > node.data){
			return false;
		}
		
		prev=node;
/*
		if(node.right != null && node.right.data < node.data ){
			return false;
		}
*/
		
		if(!isBST(node.right)){
			return false;
		}
		
		return true;
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
	
	public static void main(String args[]) {
		CheckBinaryTreeIsBST binaryTree = new CheckBinaryTreeIsBST();
			
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(25);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(17);
		root.right.left = new TreeNode(22);
		root.right.right = new TreeNode(30);
		root.right.right.right = new TreeNode(35);
		binaryTree.printInOrderTraverse(root);

		System.out.println("Binary tree iS  bst ?:- " + binaryTree.isBST(root));
		
		System.out.println();
		binaryTree.insert(17);
		binaryTree.insert(20);
		binaryTree.insert(15);
		binaryTree.insert(16);
		binaryTree.insert(5);
		binaryTree.insert(100);
		binaryTree.insert(10);
		binaryTree.insert(3);
		/*binaryTree.insert(8);*/
		binaryTree.inOrderTraverse();
		
		System.out.println();
		System.out.println("Binary tree iS  bst ?:- " + binaryTree.isBST());
	}
}
