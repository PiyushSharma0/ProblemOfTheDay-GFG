// Link: https://practice.geeksforgeeks.org/problems/set-bits0143/1
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {
    static int setBits(int N) {
        int count = 0; // Variable to store the count of set bits
        
        while (N != 0) {
            N = N & (N - 1); // Clear the least significant set bit
            count++; // Increment the count
        }
        
        return count; // Return the count of set bits
    }
}
