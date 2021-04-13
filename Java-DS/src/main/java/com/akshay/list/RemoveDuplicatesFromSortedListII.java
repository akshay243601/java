package com.akshay.list;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/***
 * Microsoft
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * https://www.youtube.com/watch?v=R6-PnHODewY
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * ********/

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode prev = dummyNode;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummyNode.next;
    }


    public ListNode deleteDuplicates1(ListNode head) {
        Set<Integer> outputs = new LinkedHashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        while(head != null) {

            if(outputs.contains(head.val)) {
                outputs.remove(head.val);
                duplicates.add(head.val);
            } else if(!duplicates.contains(head.val)) {
                outputs.add(head.val);
            }
            head = head.next;
        }

        ListNode dummyNode = new ListNode(0, null);
        ListNode node = dummyNode;
        for(Integer val : outputs) {
            ListNode new_node = new ListNode(val);
            node.next = new_node;
            node = node.next;
        }
        return dummyNode.next;
    }
}
