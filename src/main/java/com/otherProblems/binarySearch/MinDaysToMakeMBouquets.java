package com.otherProblems.binarySearch;

public class MinDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for(int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay;
        int high = maxDay;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int bouquets = calculateBouquets(bloomDay, mid, k);

            if(bouquets >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }



        return ans;
        
    }

    public int calculateBouquets(int[] bloomDay, int day, int k) {
        int bouquets = 0;
        int flowers = 0;

        for(int bloom : bloomDay) {
            if(bloom <= day) {
                flowers++;
                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets;
    }


}
