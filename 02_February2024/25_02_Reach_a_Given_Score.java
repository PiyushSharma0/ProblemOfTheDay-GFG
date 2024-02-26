// Link: https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public long count(int n) {
        long[] dp = new long[n + 1];
        int[] scores = {3, 5, 10};

        // Initialize base case
        dp[0] = 1;

        // Populate the dp array
        for (int score : scores) {
            for (int i = score; i <= n; i++) {
                dp[i] += dp[i - score];
            }
        }

        return dp[n];
    }
}
