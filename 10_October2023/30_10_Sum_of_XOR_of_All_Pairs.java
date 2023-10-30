// Link: https://practice.geeksforgeeks.org/problems/sum-of-xor-of-all-pairs0723/1#
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public long sumXOR(int arr[], int n) {
        long sum = 0;
        for (int i = 0; i < 21; i++) {
            // Count the number of elements with i'th bit set
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            // Calculate the XOR contribution of the i'th bit
            // to the sum of all pairs
            sum += (1L << i) * (long)count * (n - count);
        }
        return sum;
    }
}
