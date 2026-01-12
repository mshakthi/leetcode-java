package com.leetcode169.week18;

public class MedianOfTwoArrays {
    /**
     * Finds the median of two sorted arrays using binary search.
     * 
     * <p>This method performs binary search on the smaller array to find the correct partition
     * point where the combined arrays can be split into two equal halves (or near-equal for odd length).
     * The median is calculated based on the maximum of left elements and minimum of right elements
     * at the partition point.</p>
     * 
     * <p>Time Complexity: O(log(min(n1, n2))) where n1 and n2 are the lengths of the input arrays.
     * Space Complexity: O(1) as only constant extra space is used.</p>
     * 
     * @param nums1 the first sorted array in ascending order
     * @param nums2 the second sorted array in ascending order
     * @return the median value of the two sorted arrays combined. If the total length is even,
     *         returns the average of the two middle elements. If odd, returns the middle element.
     *         Returns 0.0 if no valid median is found (edge case).
     * 
     * @throws NullPointerException if either nums1 or nums2 is null
     * 
     * @example
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.0
     * Explanation: merged array = [1,2,3] and median is 2
     * 
     * @example
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.5
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;

        int low = 0;
        int high = n1;
        int left = (n + 1) / 2;

        while(low<=high){
            int mid1 = low + (high-low) / 2;
            int mid2 = left - mid1;

            int l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <=r2 && l2 <= r1){
                if(n%2==0){
                    return ((double) (Math.max(l1,l2) + Math.min(r1,r2))) /2.0;
                } else {
                    return Math.max(l1,l2);
                }
            } else if(l1 > r2) {
                 high = mid1-1;
            } else {
               low = mid1+1;
            }
        }

        return 0.0;
    }
}
