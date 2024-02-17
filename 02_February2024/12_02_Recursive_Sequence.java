// Link: https://www.geeksforgeeks.org/recursive-sequence/
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution{
    static long sequence(int n) {
        long result = 0;
        long mod = 1000000007;

        for (int i = 1, start = 1; i <= n; i++) {
            long product = 1;

            for (int j = 0; j < i; j++) {
                product = (product * (start + j)) % mod;
            }

            result = (result + product) % mod;
            start += i;
        }

        return result;
    }
}