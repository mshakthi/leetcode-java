package com.leetcode169.week10;

import com.commonDataTypes.ListNode;

public class RemoveNthNodeFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int i =0;
        while(i<n && fast != null){
            fast = fast.next;
            i++;
        }

        if(fast == null){
            return head.next;
        }   


        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        
        return head;
    }
    
}
