package com.leetcode169.week11;

import com.commonDataTypes.ListNode;

public class SwapNodesInPairs {

    /**
     * Swaps every two adjacent nodes in a linked list and returns the head of the modified list.
     * 
     * This method takes a linked list and swaps pairs of adjacent nodes iteratively.
     * For example, given 1->2->3->4, the method returns 2->1->4->3.
     * 
     * @param head the head node of the linked list to be processed
     * @return the head node of the modified linked list with swapped pairs,
     *         or the original head if the list is empty or contains only one node
     * 
     * @implNote Uses a dummy node to simplify edge cases and iteratively swaps
     *           pairs of nodes by adjusting their next pointers. If the list has
     *           an odd number of nodes, the last node remains in its position.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the list
     * Space Complexity: O(1) as only a constant amount of extra space is used
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr!=null && curr.next != null){
            ListNode first = curr;
            ListNode second = curr.next;
            swap(first, second);

            prev.next = second;
            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }

    public void swap(ListNode first, ListNode second){
        ListNode temp = second.next;
        second.next = first;
        first.next = temp;
    }
    
}
