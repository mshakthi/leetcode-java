package com.leetcode169.week1;

/**
 * Solution for the "Best Time to Buy and Sell Stock" problem.
 * 
 * This class finds the maximum profit that can be achieved by buying and selling a stock once.
 * The algorithm uses a single pass through the prices array to track the minimum price seen so far
 * and calculates the maximum profit at each step.
 * 
 * Time Complexity: O(n) where n is the length of the prices array
 * Space Complexity: O(1) as only constant extra space is used
 * 
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 */
public class BestTimeToBuyAndSell {
    
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;


        for(int price: prices){
            if(price < minPrice){
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
        
    }
}
