// Link: https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution 
{
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // Handle the base case where the array is empty.
        if (size == 0)
            return 0;

        // Create an array to store the last element of increasing subsequences of different lengths.
        int[] tails = new int[size];
        tails[0] = a[0]; // Initialize the first tail with the first element.

        int length = 1; // Current length of the longest increasing subsequence.

        // Iterate through the array to find and update tails.
        for (int i = 1; i < size; i++) {
            // If the current element is greater than the last tail element,
            // extend the longest subsequence by appending the current element.
            if (a[i] > tails[length - 1]) {
                tails[length] = a[i];
                length++;
            } else {
                // Otherwise, find the correct position for the current element
                // using binary search and update the tail.
                int idx = binarySearch(tails, 0, length - 1, a[i]);
                tails[idx] = a[i];
            }
        }

        // Return the length of the longest increasing subsequence.
        return length;
    }

    // Binary search to find the correct insertion position in the tails array.
    static int binarySearch(int[] tails, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == target)
                return mid;
            else if (tails[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
