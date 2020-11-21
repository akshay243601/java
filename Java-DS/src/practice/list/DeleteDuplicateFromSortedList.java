package practice.list;

public class DeleteDuplicateFromSortedList {

    private static void deleteDuplicateElement(Node head) {
        if(head == null)
            return;
        Node node = head;

        while (node != null && node.next != null) {
            if(node.data == node.next.data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(1);
        linkedList.insert(1);
        linkedList.insert(1);
        linkedList.insert(1);
        linkedList.insert(1);

        linkedList.insert(3);
        linkedList.insert(5);
        linkedList.insert(5);
        linkedList.insert(5);
        linkedList.insert(5);
        linkedList.insert(7);
        linkedList.insert(9);
        linkedList.insert(9);
        linkedList.insert(10);

        System.out.println("before Delete the duplicate");
        linkedList.printList();

        deleteDuplicateElement(linkedList.head);
        System.out.println("After Delete the duplicate");
        linkedList.printList();


    }
}
