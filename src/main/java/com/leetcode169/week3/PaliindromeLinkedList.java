package com.leetcode169.week3;

import com.commonDataTypes.ListNode;

/**
 * Solution class to determine if a singly linked list is a palindrome.
 * 
 * This class implements an efficient algorithm that:
 * 1. Finds the middle of the linked list using the slow-fast pointer technique
 * 2. Reverses the second half of the list
 * 3. Compares the first half with the reversed second half
 * 
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as it only uses constant extra space
 * 
 * Note: This implementation modifies the input linked list structure during execution
 * by reversing the second half and disconnecting it from the first half.
 */
public class PaliindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        if(head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode reversedSecondHalf = reverseList(middle.next);

        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;
        middle.next = null;


        return compareLists(p1, p2);
        
    }

    public boolean compareLists(ListNode p1, ListNode p2){
        
        while(p2!=null){
            if(p1.val!=p2.val){
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == p2;
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

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
}
