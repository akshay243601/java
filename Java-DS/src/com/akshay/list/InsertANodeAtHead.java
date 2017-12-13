package com.akshay.list;

class LinkedList5 {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}
	
	public Node insertAtHead(int data)
	{
		Node startNode = new Node(data);
		startNode.next=head;
		head=startNode;
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

public class InsertANodeAtHead {
	public static void main(String[] args){
		LinkedList5 list = new LinkedList5();
		list.push(3);
		list.push(2);
		list.push(12);
		list.push(25);
		list.push(7);
		list.printList();
		System.out.println();
		System.out.println("Insert element at head");
		int insertedValue=38;
		System.out.println(insertedValue);
		list.insertAtHead(insertedValue);
		System.out.println("After insert value is : ");
		list.printList();
	}
}
