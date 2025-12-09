package com.leetcode169.week19;

import com.commonDataTypes.ListNode;

/**
 * Solution for LeetCode problem 25: Reverse Nodes in k-Group
 * 
 * This class provides functionality to reverse nodes in a linked list in groups of k.
 * If the number of nodes is not a multiple of k, the remaining nodes are left as is.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as only constant extra space is used
 * 
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;
        ListNode nextGroup = null;

        while(true){
            ListNode kthNode = getKthNode(prevGroup, k);
            if(kthNode == null){
                break;
            }

            nextGroup = kthNode.next;
            ListNode newGroupHead = reverse(prevGroup.next, kthNode);
            ListNode oldGroupHead = prevGroup.next;
            prevGroup.next = newGroupHead;
            oldGroupHead.next = nextGroup;
            prevGroup = oldGroupHead;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode tail){
        ListNode prev = null;
        ListNode curr = head;

        while(prev != tail){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode getKthNode(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return k ==0 ? curr : null;
    }



       
}
