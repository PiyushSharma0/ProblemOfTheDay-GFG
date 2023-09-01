// Link: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

import java.util.*;

class Solution
{
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (m == 0 || n == 0)
            return 0;

        if (m > n)
            return -1; // Not enough packets to distribute

        Collections.sort(a); // Sort the array in ascending order

        long minDiff = Long.MAX_VALUE;

        // Find the minimum difference between packets given to students
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = a.get(i + m - 1) - a.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}