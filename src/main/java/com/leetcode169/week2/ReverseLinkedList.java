package com.leetcode169.week2;

import com.commonDataTypes.ListNode;

public class ReverseLinkedList {

    /**
     * Reverses a singly linked list iteratively.
     * 
     * This method reverses the direction of pointers in a linked list by iterating through
     * the list once. It uses three pointers to track the previous node, current node, and
     * next node while reversing the links between nodes.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the linked list
     * Space Complexity: O(1) as only constant extra space is used
     * 
     * @param head the head node of the linked list to be reversed
     * @return the new head node of the reversed linked list, or null if the input list was empty
     * 
     * @example
     * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
     * Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
        
    }
    
}
