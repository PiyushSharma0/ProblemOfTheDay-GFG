// Link: https://practice.geeksforgeeks.org/problems/shuffle-integers/0
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    void shuffleArray(long[] arr, int n) {
        long offset = 1000000000L; 
        for (int i = 0; i < n / 2; ++i) {
            arr[i * 2] += (arr[i] % offset) * offset;
            arr[i * 2 + 1] += (arr[n / 2 + i] % offset) * offset;
        }
        for (int i = 0; i < n; ++i) {
            arr[i] = arr[i] / offset;
        }
    }
}