package com.akshay.tree;


public class BinarySearchTreeCreate {

	static TreeNode root;
	
	BinarySearchTreeCreate(int data){
		root = new TreeNode(data);
		root.left = null;
		root.right = null;
	}
	
	private static void addNode(int data){
		addNode(root, data);
	}
	
	private static void addNode(TreeNode node, int data){
		if(data > node.data){
			if(node.right != null){
				addNode(node.right, data);
			} else {
				node.right = new TreeNode(data);
			}
		} else {
			if(node.left != null){
				addNode(node.left, data);
			} else {
				node.left = new TreeNode(data);
			}
		}
	}
	
	private static void printInOrder(){
		printInOrder(root);
	}
	
	private static void printInOrder(TreeNode node){
		if(node != null ){
			printInOrder(node.left);
			
			System.out.println(node.data);
		
			printInOrder(node.right);
		}
	}
	
	
	
	public static  void main(String args[]){
		BinarySearchTreeCreate tree = new BinarySearchTreeCreate(15);
		//15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150
		tree.addNode(200);
		tree.addNode(25);
		tree.addNode(-5);
		tree.addNode(0);
		tree.addNode(100);
		tree.addNode(20);
		tree.addNode(126);
		tree.addNode(1000);
		tree.addNode(-150);
		
		
		tree.printInOrder();
		
		

	}
	
}
