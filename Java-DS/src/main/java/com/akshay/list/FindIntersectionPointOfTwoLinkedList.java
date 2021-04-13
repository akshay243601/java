package com.akshay.list;

import com.akshay.list.LinkedList.Node;

class LinkedList {

	static Node head1, head2;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	/* Start Of Intersection Point */
	
	/*function to get the intersection point of two linked
    lists head1 and head2 */
	int getIntersectionPoint() {

		int listCount1 = getCount(head1);
		int listCount2 = getCount(head2);

		if (listCount1 > listCount2) {
			return getIntersection(listCount1 - listCount2, head1, head2);
		} else {
			return getIntersection(listCount2 - listCount1, head2, head1);
		}
	}
	
	/* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
	int getIntersection(int diff, Node node1, Node node2) {

		for (int i = 0; i < diff; i++) {
			node1 = node1.next;
		}

		while (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				return node1.data;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return -1;
	}
	
	/* Start Of Intersection Point */
	
	/*function to get the intersection point of two linked
    lists head1 and head2 */
	int getMergingPoint() {

		int listCount1 = getCount(head1);
		int listCount2 = getCount(head2);

		if (listCount1 > listCount2) {
			return getMergePoint(listCount1 - listCount2, head1, head2);
		} else {
			return getMergePoint(listCount2 - listCount1, head2, head1);
		}
	}
	

	
	int getMergePoint(int diff, Node node1, Node node2) {

		for (int i = 0; i < diff; i++) {
			node1 = node1.next;
		}
		boolean isMergePoint=false;
		int mergingNode=-1;
		while (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				if(!isMergePoint)
					mergingNode=node1.data;
				isMergePoint=true;
			}
			else{
				isMergePoint=false;
				mergingNode=-1;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		if(isMergePoint){
			return mergingNode;
		}
		return -1;
	}


	/*Takes head pointer of the linked list and
    returns the count of nodes in the list */
	private static int getCount(Node node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	/* End of Intersection Point */

}

public class FindIntersectionPointOfTwoLinkedList {
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(15);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);


		// creating second linked list
		list.head2 = new Node(15);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		System.out.println(list.getIntersectionPoint());

		System.out.println(list.getMergingPoint());
		
	}
}
