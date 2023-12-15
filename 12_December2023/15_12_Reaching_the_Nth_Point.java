// Link: https://practice.geeksforgeeks.org/problems/reaching-the-nth-point/
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int nthPoint(int n) {
        // Initialize two variables to keep track of the number of ways
        long a = 1, b = 1, mod = 1000000007;

        // Loop to calculate the number of ways to reach point N
        for (int i = 1; i < n; i++) {
            // Calculate the next value in the sequence
            long c = (a + b) % mod;

            // Update the values for the next iteration
            a = b;
            b = c;
        }

        // Return the result, which represents the number of ways to reach point N
        return (int) b;
    }
}
