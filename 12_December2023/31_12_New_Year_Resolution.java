// Link: https://www.geeksforgeeks.org/problems/good-by-2023/1
// Time Complexity: O(N * 2025) = O(N) 
// Space Complexity: O(2025) = O(1)

class Solution {
    public static boolean isPossible(int N, int[] coins) {
        int[] dp = new int[2025];
        dp[0] = 1; // Base case: 0 coins are needed to achieve a sum of 0.

        for (int i = 0; i < N; i++) {
            for (int j = 2024; j >= coins[i]; j--) {
                if (dp[j - coins[i]] == 1) {
                    dp[j] = 1;
                }
            }
        }

        // Check if any of the required sums is divisible by 20, 24, or equal to 2024.
        for (int sum = 20; sum <= 2024; sum += 20) {
            if (dp[sum] == 1) {
                return true;
            }
        }
        for (int sum = 24; sum <= 2024; sum += 24) {
            if (dp[sum] == 1) {
                return true;
            }
        }
        if (dp[2024] == 1) {
            return true;
        }

        return false;
    }
}
