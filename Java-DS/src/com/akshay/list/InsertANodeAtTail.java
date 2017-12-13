package com.akshay.list;

class LinkedList6 {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertAtTail(int data) {
		Node node = head;
		Node new_Node = new Node(data);
		while (node != null && node.next != null) {
			node = node.next;
		}
		node.next = new_Node;
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

public class InsertANodeAtTail {
	public static void main(String[] args) {
		LinkedList6 list = new LinkedList6();
		list.push(3);
		list.push(2);
		list.push(12);
		list.push(25);
		list.push(7);
		list.printList();
		System.out.println();
		System.out.println("Insert element at tail");
		int insertedValue = 38;
		System.out.println(insertedValue);
		list.insertAtTail(insertedValue);

		list.insertAtTail(56);
		list.insertAtTail(76);

		list.insertAtTail(42);

		System.out.println("After insert value is : ");
		list.printList();
	}
}
