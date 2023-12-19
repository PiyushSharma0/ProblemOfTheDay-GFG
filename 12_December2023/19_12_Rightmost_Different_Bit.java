// Link: https://practice.geeksforgeeks.org/problems/rightmost-different-bit-1587115621/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution
{
    // Function to find the position of the rightmost different bit.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        // XOR the two numbers to find the bits that are different.
        int xorResult = m ^ n;

        // If both numbers are the same, return -1.
        if (xorResult == 0) {
            return -1;
        }

        // Find the position of the rightmost set bit (1) in the XOR result.
        int position = 1;
        while ((xorResult & 1) == 0) {
            xorResult = xorResult >> 1;
            position++;
        }

        return position;
    }
}
