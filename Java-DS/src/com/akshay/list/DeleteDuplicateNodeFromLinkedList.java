package com.akshay.list;

class LinkedList4 {
	static Node head;
	public int x = 0;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void deleteDuplicateFromList() {
		Node node = head;

		/*
		 * We are finding the duplicate element As list is sorted then current
		 * and Next node value will be same
		 */
		while (node != null && node.next != null) {
			if (node.data == node.next.data) {
				System.out.print(node.data + " ");

				/*
				 * if We found any duplicate node then we can delete any one
				 * node by playing with next node value
				 */
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}

	public void push(int data) {

		/* 1. alloc the Node and put the data */
		Node node = new Node(data);

		/* 2. Make next of new Node as head */
		node.next = head;

		/* 3. Move the head to point to new Node */
		head = node;
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "  ");
			node = node.next;
		}
	}
}

public class DeleteDuplicateNodeFromLinkedList {

	public static void main(String args[]) {
		LinkedList4 list = new LinkedList4();
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(3);
		list.push(5);
		list.push(7);
		list.push(8);
		list.push(8);
		
		System.out.println("Befor delete");
		list.printList();
		System.out.println();
		System.out.println("deleted duplicate Node ");
		list.deleteDuplicateFromList();
		System.out.println();
		System.out.println("After Delete");
		list.printList();
	}
}
