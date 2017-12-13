package com.akshay.list;

class LinkedList1 {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void delete(int position) {
		if (position < 0) {
			return;
		}

		Node node = head;

		if (node == null)
			return;

		Node temp = node;

		if (position == 0) {
			head = node.next;
			return;
		}

		for (int i = 0; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null)
			return;

		temp.next = temp.next.next;
	}

	public static void printList() {

		Node node = head;
		if (node == null)
			return;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/* Function to add Node at beginning of list. */
	public static void push(int value) {

		/* 1. alloc the Node and put the data */
		Node node = new Node(value);

		/* 2. Make next of new Node as head */
		node.next = head;

		/* 3. Move the head to point to new Node */
		head = node;
	}
}

public class DeleteANodeFromLinkedList {

	public static void main(String args[]) {
		LinkedList1 list = new LinkedList1();

		list.push(3);
		list.push(2);
		list.push(12);
		list.push(25);
		list.push(7);

		list.printList();

		list.delete(1);
		System.out.println();
		System.out.println("Print after delete");
		list.printList();

	}
}
