// Link: https://practice.geeksforgeeks.org/problems/rotate-bits-1587115620/1
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.ArrayList;

class Solution
{
    ArrayList<Integer> rotate(int N, int D) {
        ArrayList<Integer> result = new ArrayList<>();

        // Mask to ensure only 16 bits are considered (since integers are assumed to be 16-bit).
        int mask = 65535;

        // Ensure D is within the range [0, 16] to handle overflow.
        D %= 16;

        // Left Rotation
        int leftPart = N >> (16 - D);
        N = (N << D) & mask;
        result.add(N | leftPart);

        // Right Rotation
        int rightPart = N >> D;
        N = (N << (16 - D)) & mask;
        result.add(N | rightPart);

        return result;
    }
}