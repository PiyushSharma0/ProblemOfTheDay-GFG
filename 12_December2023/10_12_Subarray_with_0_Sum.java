// Link: https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashSet;

class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // If the current sum is 0 or it has been seen before, return true.
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            // Add the current sum to the set.
            set.add(sum);
        }

        // If no subarray with 0 sum is found, return false.
        return false;
    }
}
