// Link: https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    // Define the modulo value
    int mod = (int) (1e9 + 7);

    // Function to calculate total ways to construct buildings
    int TotalWays(int N) {
        // Initialize variables to keep track of current, previous, and next values
        long curr, prev, next;
        curr = prev = 1;

        // Iterate from 1 to N to calculate Fibonacci sequence
        for (int i = 1; i <= N; ++i) {
            next = (curr + prev) % mod;
            prev = curr;
            curr = next;
        }

        // Return the square of the current value modulo mod
        return (int) ((curr * curr) % mod);
    }
}
