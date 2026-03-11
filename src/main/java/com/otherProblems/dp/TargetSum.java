package com.otherProblems.dp;

public class TargetSum {
    /**
     * Finds the number of ways to assign plus or minus signs to array elements
     * such that the resulting sum equals the target value.
     * 
     * This method uses dynamic programming by converting the problem into a
     * subset sum problem. It partitions the array into two subsets where:
     * - subset1 has a sum of S1 (with + signs)
     * - subset2 has a sum of S2 (with - signs)
     * 
     * The equation S1 - S2 = target, combined with S1 + S2 = sum(nums),
     * allows us to solve for S1 = (sum(nums) + target) / 2.
     * 
     * @param nums an array of non-negative integers to assign signs to
     * @param target the desired sum after assigning plus and minus signs to elements
     * @return the number of different ways to assign signs to achieve the target sum,
     *         or 0 if it's impossible (when the calculation results in a non-integer
     *         or negative subset sum)
     * 
     * @throws IllegalArgumentException if (sum - target) is negative or odd,
     *         indicating no valid assignment exists
     * 
     * Time Complexity: O(n * s2) where n is the length of nums and s2 is the
     *                  calculated subset sum value
     * Space Complexity: O(s2) for the dynamic programming array
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num; 
        }

        if(sum - target < 0 || (sum - target) % 2 != 0) {
            return 0;
        }

        int s2 = (sum - target) / 2;
        int[] dp = new int[s2 + 1];
        dp[0] = 1;

        for(int num : nums) {
            for(int j = s2; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s2];
    }
}
