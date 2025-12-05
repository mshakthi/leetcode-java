/**
 * Finds the middle node of a singly linked list.
 * <p>
 * This method uses the two-pointer (slow and fast) technique to find the middle node.
 * The slow pointer moves one step at a time while the fast pointer moves two steps.
 * When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
 * <p>
 * If the list has an even number of nodes, this method returns the second middle node.
 * For example, for list [1,2,3,4,5,6], it returns the node with value 4.
 *
 * @param head the head node of the linked list
 * @return the middle node of the linked list. If the list has an even number of nodes,
 *         returns the second middle node. Returns head if the list is empty or has only one node.
 * @throws NullPointerException if head is null (depending on the handling in the while loop)
 * 
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as only two pointers are used regardless of input size
 */
package com.leetcode169.week2;

import com.commonDataTypes.ListNode;

public class LinkedListMiddle {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
        
    }
    
}
