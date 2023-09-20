// Link: https://practice.geeksforgeeks.org/problems/find-first-set-bit-1587115620/1
// Time Complexity: O(log N) (N is the number of bits in the binary representation of n)
// Space Complexity: O(1)

class Solution
{
    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        // If n is 0, there is no set bit, so return 0.
        if (n == 0) {
            return 0;
        }
        
        // Initialize a variable to keep track of the position.
        int position = 1;
        
        // Iterate through each bit of n.
        while ((n & 1) != 1) {
            // Right shift n by 1 to check the next bit.
            n = n >> 1;
            
            // Increment the position.
            position++;
        }
        
        return position;
    }
}