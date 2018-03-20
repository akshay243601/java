package com.akshay.list;

public class InsertNodeAtHead {

	public static Node head;

	public static void insertAtHead(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public static void push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			node.next = temp;
			head = node;
		}
	}

	public static void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		push(4);
		push(5);
		push(7);
		push(9);
		push(10);
		push(12);
		push(3);
		push(2);
		insertAtHead(1);
		print();
	}
}
