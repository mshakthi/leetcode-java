package com.leetcode169.week11;

import com.commonDataTypes.ListNode;

public class OddEvenLinkedList {
        /**
         * Rearranges a linked list by grouping all odd-indexed nodes together followed by even-indexed nodes.
         * The relative order of nodes within each group should remain as it was in the input list.
         * Node indexing starts at 1 (the first node is considered odd).
         * 
         * Algorithm:
         * - Maintains two separate lists: one for odd-indexed nodes and one for even-indexed nodes
         * - Traverses the original list, alternately assigning nodes to odd and even lists
         * - Connects the end of the odd list to the head of the even list
         * 
         * Time Complexity: O(n) where n is the number of nodes in the linked list
         * Space Complexity: O(1) as only a constant amount of extra space is used
         * 
         * @param head the head node of the linked list to rearrange
         * @return the head node of the rearranged linked list with odd-indexed nodes first, 
         *         followed by even-indexed nodes. Returns null if input is null, or the original
         *         head if the list has only one node.
         * 
         * Example:
         * Input: 1->2->3->4->5
         * Output: 1->3->5->2->4
         */
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode oddHead = head;
            ListNode evenHead = head.next;
            ListNode odd = oddHead;
            ListNode even = evenHead;

            while(even!=null && even.next!=null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return oddHead;
    }
}
