package com.akshay.list;

class LinkedList3 {

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

	public static int getMiddleOfLinkedList() {

		Node slowNode = head;
		Node fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode.data;
	}
}

public class FindMiddleOfLinkedList {

	public static void main(String args[]) {
		LinkedList3 list = new LinkedList3();
		list.push(3);
		list.push(13);
		
		list.printList();
		System.out.println("Middle Element is :- " + list.getMiddleOfLinkedList());

		
		list.push(6);
		list.push(8);
		
		list.printList();
		System.out.println("Middle Element is :- " + list.getMiddleOfLinkedList());
		
		
		list.push(12);
		list.push(32);
		
		list.printList();
		System.out.println("Middle Element is :- " + list.getMiddleOfLinkedList());
		
		
		list.push(134);
		list.printList();

		System.out.println("Middle Element is :- " + list.getMiddleOfLinkedList());
	}

}



/*Output:- 

13 3 Middle Element is :- 3
8 6 13 3 Middle Element is :- 13
32 12 8 6 13 3 Middle Element is :- 6
134 32 12 8 6 13 3 Middle Element is :- 8

*/