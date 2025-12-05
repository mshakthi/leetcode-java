package com.leetcode169.week1;

import com.commonDataTypes.ListNode;

/**
 * A class that provides functionality to merge two sorted linked lists into one sorted linked list.
 * 
 * This class implements a solution for merging two sorted singly-linked lists by comparing
 * the values of nodes from both lists and building a new sorted list.
 */

/**
 * Merges two sorted linked lists into a single sorted linked list.
 * 
 * This method takes two sorted linked lists as input and merges them into one sorted list
 * by iteratively comparing the values of nodes from both lists. The merge is done in-place
 * by rearranging the node pointers.
 * 
 * Algorithm:
 * 1. Creates a dummy node to simplify edge cases
 * 2. Uses two pointers (p1 and p2) to traverse both input lists
 * 3. Compares values at current positions and appends the smaller node to the result
 * 4. Advances the pointer of the list from which the node was taken
 * 5. Appends any remaining nodes from either list after one list is exhausted
 * 
 * @param list1 the head of the first sorted linked list (can be null)
 * @param list2 the head of the second sorted linked list (can be null)
 * @return the head of the merged sorted linked list, or null if both input lists are null
 * 
 * Time Complexity: O(n + m) where n and m are the lengths of list1 and list2
 * Space Complexity: O(1) as only a constant amount of extra space is used
 * 
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeSortedList {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        if(p1 != null){
            current.next = p1;
        } else if(p2 != null){
            current.next = p2;
        }

        return dummy.next;
        
    }
}
