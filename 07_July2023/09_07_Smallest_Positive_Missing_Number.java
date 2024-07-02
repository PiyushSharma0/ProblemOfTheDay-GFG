// Link: https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public static int missingNumber(int[] arr, int n) {
        // Iterate over the array and perform swaps to put each number in its correct position
        for (int i = 0; i < n; i++) {
            // While the current number is within the range (1 to n) and is not in its correct position
            while (arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1]) {
                // Swap the current number with the number at its correct position
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }
        
        // Iterate over the array again to find the missing number
        for (int i = 0; i < n; i++) {
            // If the number at index i is not equal to i+1, then i+1 is the missing number
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If no missing number is found, then the missing number is n+1
        return n + 1;
    }
}
