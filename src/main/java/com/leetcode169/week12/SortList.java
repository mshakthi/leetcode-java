package com.leetcode169.week12;

import com.commonDataTypes.ListNode;

public class SortList {
    /**
     * Sorts a linked list in ascending order using the merge sort algorithm.
     * This method uses a divide-and-conquer approach by recursively splitting the list
     * into two halves, sorting each half, and then merging them back together.
     * 
     * Time Complexity: O(n log n) where n is the number of nodes in the list
     * Space Complexity: O(log n) due to the recursive call stack
     * 
     * @param head the head node of the linked list to be sorted
     * @return the head node of the sorted linked list, or null if the input is null
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);

        return merge(leftSorted, rightSorted);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        }

        if(l2 != null){
            current.next = l2;
        }

        return dummy.next;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
