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
		LinkedList8 reversedLinkedList = new LinkedList8();

		reversedLinkedList.head = null;

		Node node = head;
		Node temp = null;
		while (node != null) {

			temp = new Node(node.data);
			temp.next=reversedLinkedList.head;
			reversedLinkedList.head=temp;

			node = node.next;
		}

		head = reversedLinkedList.head;
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
		list.push(3);
		list.push(2);
		list.push(12);
		list.push(25);
		list.push(7);
		list.printList();
		System.out.println();
		System.out.println("Linked List ");

		System.out.println("Reverse of Linked List");
		list.reverseOfLinkedListItems();
		list.printList();

	}
}
