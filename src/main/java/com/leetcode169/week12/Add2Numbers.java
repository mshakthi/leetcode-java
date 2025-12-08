package com.leetcode169.week12;

import com.commonDataTypes.ListNode;

public class Add2Numbers {
    /**
     * Adds two non-negative integers represented by linked lists and returns the sum as a linked list.
     * The digits are stored in reverse order, with each node containing a single digit.
     * 
     * @param l1 the first linked list representing a non-negative integer
     * @param l2 the second linked list representing a non-negative integer
     * @return a new linked list representing the sum of the two numbers
     * 
     * @example
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807
     * 
     * @example
     * Input: l1 = [9,9,9], l2 = [1]
     * Output: [0,0,0,1]
     * Explanation: 999 + 1 = 1000
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode current = dummy;

        int carry = 0;

        while(p1 != null || p2 != null){
            int val1 = (p1!=null) ? p1.val : 0;
            int val2 = (p2!=null) ? p2.val : 0;
            int sum = val1 + val2 + carry;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }

            carry = sum / 10;
              
        }

        if(carry > 0){
            current.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
