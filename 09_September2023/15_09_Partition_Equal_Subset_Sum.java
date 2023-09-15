// Link: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
// Time Complexity: O(N * target)
// Space Complexity: O(N * target)

import java.util.Arrays;

class Solution {
    // Helper function to recursively check if there exists a subset that adds up to 'target'
    public int canPart(int N, int i, int[] arr, int target, int[][] dp) {
        // If the target becomes 0, it means we found a subset with the desired sum.
        if (target == 0)
            return 1; // Return 1 to indicate success.

        // If we have processed all elements in the array and haven't found a subset, return 0.
        if (i >= N)
            return 0;

        // If this subproblem has already been solved, return the stored result.
        if (dp[i][target] != -1)
            return dp[i][target];

        // Try including the current element in the subset (if it's not greater than the target).
        int take = 0;
        if (target >= arr[i]) {
            take = canPart(N, i + 1, arr, target - arr[i], dp);
        }

        // Try excluding the current element from the subset.
        int notTake = canPart(N, i + 1, arr, target, dp);

        // Store the result in the DP table. If either taking or not taking leads to a successful partition, return 1; otherwise, return 0.
        return dp[i][target] = (take == 1 || notTake == 1) ? 1 : 0;
    }

    // Main function to check if the array can be divided into two equal-sum subsets.
    public int equalPartition(int N, int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += arr[i];
        }
        
        // If the sum is odd, it's impossible to partition into equal subsets.
        if (sum % 2 != 0)
            return 0;

        int target = sum / 2;
        int[][] dp = new int[N][target + 1];

        // Initialize the DP table with -1 (indicating subproblems haven't been solved yet).
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Call the recursive function to check if there exists a partition.
        return canPart(N, 0, arr, target, dp);
    }
}
