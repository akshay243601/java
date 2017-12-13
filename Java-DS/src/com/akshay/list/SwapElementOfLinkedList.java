package com.akshay.list;

class LinkedList2 {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
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

	public static void printList() {

		Node node = head;
		if (node == null)
			return;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/*
	 * Function to swap Nodes x and y in linked list by changing links
	 */
	public static void swap(int x, int y) {

		// Nothing to do if x and y are same
		if (x == y) {
			return;
		}

		// Search for x (keep track of prevX and CurrX)
		Node preX = null, currX = head;
		while (currX != null && currX.data != x) {
			preX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		Node preY = null, currY = head;
		while (currY != null && currY.data != y) {
			preY = currY;
			currY = currY.next;
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null) {
			return;
		}

		// If x is not head of linked list
		if (preX != null) {
			preX.next = currY;
		} else {
			head = currY; // make y the new head
		}

		// If y is not head of linked list
		if (preY != null) {
			preY.next = currX;
		} else {
			head = currX; // make x the new head
		}

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

	}

}

public class SwapElementOfLinkedList {

	public static void main(String args[]) {

		LinkedList2 list = new LinkedList2();
		list.push(3);
		list.push(13);
		list.push(6);
		list.push(8);
		list.push(12);
		list.push(32);
		list.push(134);
		list.printList();
		list.swap(13, 12);

		System.out.println();
		System.out.println("Print after Swap");
		list.printList();

	}
}
