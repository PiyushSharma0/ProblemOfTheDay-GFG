// Link: https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1#
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    int findMaxSum(int arr[], int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return arr[0];
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            // Calculate the maximum sum considering two cases: including current element or excluding it
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[n - 1];
    }
}
