package com.akshay.list;

import com.akshay.list.LinkedList.Node;

public class PrintReverseOfLinkedList {

	private static void printReverse(Node node) {

		if (node == null)
			return;
		printReverse(node.next);
		System.out.println(node.data);
	}
	
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(15);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);
		
		
		printReverse(list.head1);
	}

}
