package practice.list;

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        node.next = newNode;
    }

    public void printList() {
        Node node = head;
        while(node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
    }
}

