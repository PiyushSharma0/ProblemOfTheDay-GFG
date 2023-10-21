// Link: https://practice.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n/
// Time Complexity: O(N)
// Auxiliary Space: O(1)

class Solution {
    // This function calculates the sum of divisors for a given integer N.
    public long sumOfDivisors(int N) {
        long out = 0;

        // Iterate through integers from 1 to N.
        for (int i = 1; i <= N; ++i) {
            // Add the product of (N / i) and i to the result.
            out += ((long)N / i) * i;
        }

        return out;
    }
}
