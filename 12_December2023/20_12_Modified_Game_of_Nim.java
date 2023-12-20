// Link: https://practice.geeksforgeeks.org/problems/modified-game-of-nim/0
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    static int findWinner(int n, int[] A) {
        // Calculate the XOR of all elements in the array
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= A[i];
        }

        // If the XOR is initially 0, player 1 wins
        if (xor == 0) {
            return 1;
        } else {
            // If the XOR is initially non-zero, player 1 wins if the number of elements is even,
            // otherwise player 2 wins
            return n % 2 == 0 ? 1 : 2;
        }
    }
}
