package com.otherProblems.binarySearch;

/**
 * Solves the Koko Eating Bananas problem using binary search on eating speed.
 */
public class KokoEatingBananas {
    /**
     * Returns the minimum integer eating speed such that all banana piles
     * are finished within {@code h} hours.
     *
     * @param piles array where each value is the number of bananas in a pile
     * @param h total available hours
     * @return minimum valid eating speed
     */
    public int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;

        for(int pile: piles) {
            high = Math.max(high, pile);
        }

        int low = 1;
        int ans = -1;
        
        while(low<=high) {
            int mid = low +(high-low)/2;

            if(requiredTime(piles, mid) <= h){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }


        }

        return ans;

        
    }

    /**
     * Computes total hours required to finish all piles at a fixed eating speed.
     *
     * @param piles array of banana piles
     * @param hour bananas eaten per hour
     * @return total hours required
     */
    public int requiredTime(int[] piles, int hour) {
        int ans = 0;

        for(int pile: piles){
            ans += Math.ceil((double)pile/(double)hour);
        }

        return ans;
    }
}
