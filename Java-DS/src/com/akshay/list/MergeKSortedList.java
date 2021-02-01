package com.akshay.list;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        if(lists.length == 1) {
            return lists[0];
        }

        ListNode output = lists[0];
        for(int i = 1; i < lists.length; i++) {
            output = mergeList(output, lists[i]);
        }


        return output;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        ListNode temp = output;
        while(l1 != null && l2 != null) {
            int val = 0;
            if(l1.val > l2.val) {
                val = l2.val;
                l2 = l2.next;
            } else {
                val = l1.val;
                l1 = l1.next;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        while(l1 != null) {
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        return output.next;
    }


    public void printList(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val + " --> ");
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();

        //[[1,4,5],[1,3,4],[2,6]]
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);


        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        listNode3.next.next = new ListNode(6);

        mergeKSortedList.printList(mergeKSortedList.mergeKLists(new ListNode[]{
                listNode1,
                listNode2,
                listNode3
        }));
    }
}