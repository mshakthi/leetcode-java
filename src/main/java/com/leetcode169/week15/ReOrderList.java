package com.leetcode169.week15;

import com.commonDataTypes.ListNode;

public class ReOrderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode mid = findMiddle(head);
        ListNode secondHalfHead = mid.next;
        mid.next = null; // Split the list into two halves

        // Step 2: Reverse the second half of the list
        ListNode reversedSecondHalf = reverseList(secondHalfHead);
        
        // Step 3: Merge the two halves
        head = merge(head, reversedSecondHalf);        
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(first != null && second != null) {
            current.next = first;
            first = first.next;
            current = current.next;

            current.next = second;
            second = second.next;
            current = current.next;
        }

        if(first != null) {
            current.next = first;
        }

        if(second != null) {
            current.next = second;
        }

        return dummy.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }
    
}
