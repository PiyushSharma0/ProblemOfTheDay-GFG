// Link: https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int nonZeroIndex = 0;

        // Traverse the array and move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Swap the non-zero element with the element at the nonZeroIndex
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    }
}