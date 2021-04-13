package com.akshay.list;

public class MergeTwoSortedList {
//    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private static Node mergeSortedList(Node node1, Node node2) {
        Node result = new Node(0);
        Node temp = result;

        while(node1 != null && node2 != null) {
            if(node1.data > node2.data) {
                temp.next = node2;
                node2 = node2.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
            }
            temp = temp.next;
        }

        if(node1 != null) {
            temp.next = node1;
        }

        if(node2 != null) {
            temp.next = node2;
        }

        return result.next;
    }

    public static void printList(Node node) {
        if (node == null)
            return;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(7);
        node1.next.next.next.next = new Node(9);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(6);
        node2.next.next.next = new Node(8);
        node2.next.next.next.next = new Node(9);
        node2.next.next.next.next.next = new Node(10);

        printList(mergeSortedList(node1, node2));


    }
}
