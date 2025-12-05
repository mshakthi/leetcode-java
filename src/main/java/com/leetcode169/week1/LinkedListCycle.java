package com.leetcode169.week1;

import com.commonDataTypes.ListNode;

/**
 * LinkedListCycle class provides a solution to detect if a linked list contains a cycle.
 * 
 * This class implements Floyd's Cycle-Finding Algorithm (also known as the "tortoise and hare" algorithm)
 * to determine whether a linked list has a cycle in it.
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 */

/**
 * Detects whether a linked list contains a cycle.
 * 
 * Uses Floyd's Cycle-Finding Algorithm with two pointers:
 * - A slow pointer that moves one step at a time
 * - A fast pointer that moves two steps at a time
 * 
 * If there is a cycle, the fast pointer will eventually meet the slow pointer.
 * If there is no cycle, the fast pointer will reach the end of the list.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as only two pointers are used
 * 
 * @param head the head node of the linked list
 * @return true if the linked list contains a cycle, false otherwise
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

     ListNode slow = head;
     ListNode fast = head;

     while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;

         if(slow == fast){
             return true;
         }
     }

     return false;
        
    }
    
}
