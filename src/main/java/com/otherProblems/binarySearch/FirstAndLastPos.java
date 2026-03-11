package com.otherProblems.binarySearch;

public class FirstAndLastPos {
    int n;
    public int[] searchRange(int[] nums, int target) {
        n = nums.length;
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;  
    }

    private int findFirst(int[] nums, int target) {
        int low = 0, high = n-1, ans = -1;

        while(low <=high) {
            int mid = (high + low) /2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;   // move left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = n-1, ans = -1;

        while(low<=high){
            int mid = (high + low) /2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;    // move right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
}
