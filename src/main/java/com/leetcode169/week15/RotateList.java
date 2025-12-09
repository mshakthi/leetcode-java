package com.leetcode169.week15;

import com.commonDataTypes.ListNode;

public class RotateList {
    /**
     * Rotates a linked list to the right by k positions.
     * 
     * The rotation works by moving the last k nodes to the front of the list.
     * For example, if the list is 1->2->3->4->5 and k=2, the result will be 4->5->1->2->3.
     * 
     * Algorithm:
     * 1. First, handles edge cases where rotation is not needed (empty list, single node, or k=0)
     * 2. Calculates the length of the list (n) and finds the tail node
     * 3. Normalizes k using modulo operation (k = k % n) to handle cases where k > n
     * 4. Finds the new tail position at (n-k-1)th node from the head
     * 5. The new head becomes the node after the new tail
     * 6. Breaks the link at new tail and connects the old tail to the old head
     * 
     * @param head The head node of the linked list to rotate
     * @param k The number of positions to rotate the list to the right
     * @return The head node of the rotated linked list
     * 
     * Time Complexity: O(n) where n is the number of nodes in the list
     * Space Complexity: O(1) as only constant extra space is used
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        int n =1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            n++;    
        }

        k = k%n;
        if(k == 0) {
            return head;
        }

        ListNode newTail = head;
        for(int i =0;i<n-k-1;i++){
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
