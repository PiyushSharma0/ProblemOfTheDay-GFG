// Link: https://practice.geeksforgeeks.org/problems/grinding-geek/0/
// Time Complexity: O(N * total)
// Space Complexity: O(N * total)


import java.util.Arrays;

class Solution {
    public int solve(int i, int total, int[] cost, int[][] dp) {
        if (i == cost.length)
            return 0;

        if (dp[i][total] != -1)
            return dp[i][total];

        int t = 0, nt = 0;
        if (total >= cost[i]) {
            int ac = cost[i] - (int) Math.floor(0.9 * cost[i]); // actual cost that the user bears
            t = 1 + solve(i + 1, total - ac, cost, dp);
        }
        nt = solve(i + 1, total, cost, dp); // for non-taking case

        return dp[i][total] = Math.max(t, nt);
    }

    public int max_courses(int n, int total, int[] cost) {
        int[][] dp = new int[n][total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, total, cost, dp);
    }
}
