package com.leetcode169.week2;

public class FirstBadVersion {

    /**
     * Finds the first bad version using binary search algorithm.
     * <p>
     * This method efficiently searches through versions numbered from 1 to n to identify
     * the first version that is marked as bad. It assumes that once a version is bad,
     * all subsequent versions are also bad.
     * </p>
     * 
     * <p>
     * The algorithm uses binary search to minimize the number of API calls to isBadVersion(),
     * achieving O(log n) time complexity instead of O(n) for a linear search.
     * </p>
     * 
     * @param n the total number of versions, where versions are numbered from 1 to n
     * @return the version number of the first bad version
     * 
     * @implNote Uses binary search with careful mid-point calculation (low + (high - low) / 2)
     *           to avoid integer overflow that could occur with (low + high) / 2
     * 
     * @throws IllegalArgumentException if n is less than 1 (implementation dependent)
     * 
     * @see #isBadVersion(int)
     */
    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    private boolean isBadVersion(int mid) {
        return false;
    }

}
