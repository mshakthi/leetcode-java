package com.leetcode169.week17;

import com.commonDataTypes.ListNode;

public class MergeKSortedLists {
    /**
     * Merges k sorted linked lists into one sorted linked list using a divide-and-conquer approach.
     * 
     * The algorithm uses an iterative bottom-up merge strategy, similar to merge sort:
     * - Initially merges lists in pairs (interval = 1)
     * - Then merges the results in groups of 4 (interval = 2)
     * - Continues doubling the interval until all lists are merged
     * 
     * Time Complexity: O(N log k) where N is the total number of nodes across all lists
     * and k is the number of lists. Each node is processed log k times.
     * 
     * Space Complexity: O(1) as the merging is done in-place using the input array.
     * 
     * @param lists an array of ListNode representing the heads of k sorted linked lists
     * @return the head of the merged sorted linked list, or null if the input is null/empty
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        int interval = 1;
        int n = lists.length;
        while(interval < n){
            for(int i =0;i+interval < n;i = i + interval*2){
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null){
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}
