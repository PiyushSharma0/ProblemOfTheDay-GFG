// Link: https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    int transitionPoint(int arr[], int n) {
        int left = 0; // Initialize the left pointer to the beginning of the array.
        int right = n - 1; // Initialize the right pointer to the end of the array.

        // Perform a binary search to find the transition point.
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle index to avoid integer overflow.

            if (arr[mid] == 0) {
                left = mid + 1; // Move the left pointer to the right half.
            } else {
                right = mid; // Move the right pointer to the left half.
            }
        }

        // Check if the element at the 'left' index is 1 (the transition point) and return its index, or return -1 if no transition point is found.
        return arr[left] == 1 ? left : -1;
    }
}
