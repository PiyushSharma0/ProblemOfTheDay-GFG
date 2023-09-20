// Link: https://practice.geeksforgeeks.org/problems/print-first-n-fibonacci-numbers1002/1
// Time Complexity: O(N) (N is the number of Fibonacci numbers to be printed)
// Space Complexity: O(N) (N is the number of Fibonacci numbers to be printed)

class Solution {
    // Function to return a list containing the first n Fibonacci numbers.
    public static long[] printFibb(int n) {
        if (n <= 0) {
            return new long[0]; // Return an empty array for n <= 0
        } else if (n == 1) {
            return new long[] { 1 }; // Return [1] for n = 1
        }

        long[] result = new long[n];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }
}