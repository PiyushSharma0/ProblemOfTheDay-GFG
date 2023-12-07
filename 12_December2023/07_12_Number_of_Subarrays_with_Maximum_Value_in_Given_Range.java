// Link: https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Solution {
    
    static long countSubarrays(int a[], int n, int L, int R) {
        long count = 0;

        for (int i = 0; i < n; i++) {
            int maxElement = a[i];

            for (int j = i; j < n; j++) {
                maxElement = Math.max(maxElement, a[j]);

                if (maxElement >= L && maxElement <= R) {
                    // Increment count for valid subarray
                    count++;
                } else if (maxElement > R) {
                    // Break the inner loop if the maximum element exceeds R
                    break;
                }
            }
        }

        return count;
    }