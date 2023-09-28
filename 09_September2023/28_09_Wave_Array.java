// Link: https://practice.geeksforgeeks.org/problems/wave-array-1587115621/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public static void convertToWave(int n, int[] a) {
        // Traverse the array from index 1 and swap adjacent elements
        for (int i = 1; i < n; i += 2) {
            // Swap a[i] and a[i-1]
            int temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }
}
