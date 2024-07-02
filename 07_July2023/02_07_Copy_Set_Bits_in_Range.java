// Link: https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // Create a mask with all bits set to 1.
        int mask = (1 << (r - l + 1)) - 1;
        
        // Shift the mask to the left by (l - 1) positions.
        mask = mask << (l - 1);
        
        // Apply the mask to the 'y' variable.
        mask = mask & y;
        
        // Set the bits in 'x' based on the masked bits from 'y'.
        x = x | mask;
        
        // Return the updated 'x' value.
        return x;
    }
}
