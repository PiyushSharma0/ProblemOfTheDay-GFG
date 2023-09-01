// Link: https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int xor = 0;
        
        // XOR all the numbers to get A XOR B
        for (int num : nums) {
            xor ^= num;
        }
        
        // Find the rightmost bit where A and B differ
        int diffBit = 1;
        while ((xor & diffBit) == 0) {
            diffBit <<= 1;
        }
        
        int result[] = {0, 0};
        
        // Divide the numbers into two groups based on the diffBit
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        
        return result;
    }
}
