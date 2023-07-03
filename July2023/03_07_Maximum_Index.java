// Link: https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    int maxIndexDiff(int arr[], int n) {
        // Create arrays to store the minimum element on the left side and the maximum element on the right side for each index
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Initialize the first element as the minimum for leftMin array
        leftMin[0] = arr[0];
        // Traverse the array from left to right and store the minimum element encountered so far
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }

        // Initialize the last element as the maximum for rightMax array
        rightMax[n - 1] = arr[n - 1];
        // Traverse the array from right to left and store the maximum element encountered so far
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        // Initialize variables for indices and maximum difference
        int i = 0, j = 0, maxDiff = -1;
        // Compare the minimum element on the left side with the maximum element on the right side
        while (i < n && j < n) {
            // If the minimum element on the left is less than or equal to the maximum element on the right
            if (leftMin[i] <= rightMax[j]) {
                // Update the maximum difference if the current difference is greater
                maxDiff = Math.max(maxDiff, j - i);
                // Move the right index forward to explore more potential differences
                j++;
            } else {
                // Move the left index forward if the minimum element on the left is greater than the maximum element on the right
                i++;
            }
        }

        // Return the maximum difference
        return maxDiff;
    }
}
