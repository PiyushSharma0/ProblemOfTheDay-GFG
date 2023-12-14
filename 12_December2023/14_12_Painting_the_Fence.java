// Link: https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1#
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public long countWays(int n, int k) {
        // Define the modulo value
        long mod = 1000000007;

        // Initialize variables to track the number of ways
        long same = 0;  // Number of ways to paint the current post the same as the previous one
        long diff = k;  // Number of ways to paint the current post differently from the previous one
        long total = same + diff;  // Total number of ways for the current post

        // Iterate from the 2nd post to the nth post
        for (int i = 2; i <= n; ++i) {
            // Calculate the number of ways to paint the current post the same as the previous one
            same = diff * 1;

            // Calculate the number of ways to paint the current post differently from the previous one
            diff = (total * (k - 1)) % mod;

            // Calculate the total number of ways for the current post
            total = (same + diff) % mod;
        }

        // Return the total number of ways modulo the defined value
        return total;
    }
}
