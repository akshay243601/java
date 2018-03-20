package com.akshay.list;

import com.akshay.list.Node;;

public class ReverseOfLinkedList {
	Node head;
	
	public void push(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
		} else {
			Node temp = this.head;
			node.next = temp;
			this.head = node;
		}
	}

	public void printList() {
		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private void reverseLinkedList() {
		ReverseOfLinkedList reverseList = new ReverseOfLinkedList();
		
		Node node = this.head;
		
		while(node != null){
			
			Node temp = new Node(node.data);
			temp.next = reverseList.head;
			reverseList.head = temp;
			node = node.next;
		}
		
		this.head = reverseList.head;
		
	}
	
	public static void main(String[] args) {
		ReverseOfLinkedList obj = new ReverseOfLinkedList();
		obj.push(4);
		obj.push(5);
		obj.push(7);
		obj.push(9);
		obj.push(10);
		obj.push(12);
		obj.push(3);
		obj.push(2);
		System.out.println();

		System.out.println("Before Reverse");
		
		obj.printList();
		
		
		obj.reverseLinkedList();
		System.out.println();
		System.out.println("After Reverse");
		System.out.println();
		obj.printList();

	}

}
