// Link: https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initialize the result with the initial difference
        int result = arr[n - 1] - arr[0];

        // Step 3: Iterate through the array and update result
        for (int i = 0; i < n - 1; i++) {
            int currentTower = arr[i];
            int nextTower = arr[i + 1];

            int subtract = Math.min(currentTower - k, arr[0] + k);
            int add = Math.max(nextTower + k, arr[n - 1] - k);

            result = Math.min(result, add - subtract);
        }

        return result;
    }
}
