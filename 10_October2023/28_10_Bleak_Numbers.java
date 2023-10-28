// Link: https://practice.geeksforgeeks.org/problems/bleak-numbers1011/1#
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Solution{
    public int is_bleak(int n) {
        for (int x = 0; x <= n; x++) {
            if (x + countSetBits(x) == n) {
                return 0; // Not Bleak
            }
        }
        return 1; // Bleak
    }

    // Function to count the number of set bits in an integer
    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}