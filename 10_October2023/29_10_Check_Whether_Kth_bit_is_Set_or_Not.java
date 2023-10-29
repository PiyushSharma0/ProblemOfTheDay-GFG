// Link: https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1#
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        // Right shift the number N by K positions to bring the Kth bit to the LSB position.
        // Then, use a bitwise AND operation to check if the Kth bit is 1.
        return ((n >> k) & 1) == 1;
    }
}
