package com.leetcode169.week9;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int dipIndex = -1;

        // Step 1: Find the dip index
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                dipIndex = i;
                break;      
            }
        }

        if(dipIndex == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Step 2: Find the just larger element to swap with
        for(int i = nums.length - 1; i > dipIndex; i--){
            if(nums[i] > nums[dipIndex]){
                // Step 3: Swap
                int temp = nums[i];
                nums[i] = nums[dipIndex];
                nums[dipIndex] = temp;
                break;  
            }
        }

        // Step 4: Reverse the suffix
        reverse(nums, dipIndex + 1, nums.length - 1); 
    }


    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
