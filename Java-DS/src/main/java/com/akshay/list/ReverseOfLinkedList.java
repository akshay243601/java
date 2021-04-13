package com.akshay.list;

class LinkedList8 {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public Node reverseOfLinkedListItems() {
		//New Dummy Node for reversing the list
		Node dummyNode = null;
		Node node = head;
		while (node != null) {

			// Logic : Add value to head again and again.
			Node newNode = new Node(node.data);
			newNode.next = dummyNode;
			dummyNode = newNode;

			node = node.next;
		}

		head = dummyNode;
		return head;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

public class ReverseOfLinkedList {
	public static void main(String[] args) {
		LinkedList8 list = new LinkedList8();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.printList();
		System.out.println();
		System.out.println("Linked List ");

		System.out.println("Reverse of Linked List");
		list.reverseOfLinkedListItems();
		list.printList();

	}
}
