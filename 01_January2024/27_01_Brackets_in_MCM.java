// Link: https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication/0
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

class Solution {
    static String matrixChainOrder(int p[], int n) {
        Pair[][] dp = new Pair[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (gap == 1) {
                    String res = "0";
                    res = String.valueOf((char)('A' + i));
                    dp[i][j] = new Pair(0, res);
                } else {
                    dp[i][j] = new Pair(Integer.MAX_VALUE, "-1");
                    for (int k = i + 1; k <= j - 1; k++) {
                        int cost = p[i] * p[k] * p[j] + dp[i][k].first + dp[k][j].first;
                        if (dp[i][j].first > cost) {
                            dp[i][j].first = cost;
                            dp[i][j].second = "(" + dp[i][k].second + dp[k][j].second + ")";
                        }
                    }
                }
            }
        }

        return dp[0][n - 1].second;
    }
    
    static class Pair {
        int first;
        String second;

        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}