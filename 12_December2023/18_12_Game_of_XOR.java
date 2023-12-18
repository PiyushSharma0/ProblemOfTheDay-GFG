// Link: https://practice.geeksforgeeks.org/problems/game-of-xor/0/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    // Method to find the bit-wise XOR of values of all subarrays of array A
    static int gameOfXor(int N, int[] A) {
        // If the length of the array is even, the XOR of all subarrays is 0
        if (N % 2 == 0)
            return 0;

        // Initialize XOR to 0
        int XOR = 0;

        // Iterate over the array with a step of 2
        for (int i = 0; i < N; i += 2)
            // XOR the current element with the running XOR value
            XOR ^= A[i];

        // Return the final XOR value
        return XOR;
    }
}
