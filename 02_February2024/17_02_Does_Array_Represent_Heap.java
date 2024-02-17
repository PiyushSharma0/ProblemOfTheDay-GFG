// Link: https://www.geeksforgeeks.org/problems/does-array-represent-heap/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean countSub(long arr[], long n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            // Check if left child exists and is greater than the current node
            if (leftChildIndex < n && arr[leftChildIndex] > arr[i]) {
                return false;
            }

            // Check if right child exists and is greater than the current node
            if (rightChildIndex < n && arr[rightChildIndex] > arr[i]) {
                return false;
            }
        }

        return true;
    }
}