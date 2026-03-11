package com.otherProblems.binarySearch;

public class KthMissingNumber {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
        
    }
}
