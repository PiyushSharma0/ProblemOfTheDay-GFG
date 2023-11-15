// Link:https://www.geeksforgeeks.org/problems/better-string/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.Arrays;

class Solution {
    public static String betterString(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Calculate the count of distinct subsequences for str1 and str2
        int count1 = countDistinctSubsequences(str1, m);
        int count2 = countDistinctSubsequences(str2, n);

        // Compare the counts and return the better string
        if (count1 >= count2) {
            return str1;
        } else {
            return str2;
        }
    }

    // Helper function to calculate the count of distinct subsequences
    private static int countDistinctSubsequences(String str, int n) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // Map to store the last index of each character in the string
        int[] lastOccurrence = new int[256];
        Arrays.fill(lastOccurrence, -1);

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % MOD;

            // If the current character has occurred before, subtract the count
            // of subsequences ending at the last occurrence of the character
            if (lastOccurrence[str.charAt(i - 1)] != -1) {
                dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i - 1)] - 1] + MOD) % MOD;
            }

            // Update the last occurrence index of the current character
            lastOccurrence[str.charAt(i - 1)] = i;
        }

        return dp[n];
    }
}
