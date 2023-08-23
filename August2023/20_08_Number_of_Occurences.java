// Link: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    // Function to count the occurrences of element x in a sorted array arr of length n
    int count(int[] arr, int n, int x) {
        // Find the first occurrence of element x
        int firstOccurrence = findFirstOccurrence(arr, n, x);
        
        // If element x is not found, return 0
        if (firstOccurrence == -1) {
            return 0;
        }
        
        // Find the last occurrence of element x
        int lastOccurrence = findLastOccurrence(arr, n, x);
        
        // Return the count of occurrences of element x
        return lastOccurrence - firstOccurrence + 1;
    }
    
    // Function to find the first occurrence of element x in a sorted array arr of length n
    int findFirstOccurrence(int[] arr, int n, int x) {
        int left = 0;       // Left pointer
        int right = n - 1;  // Right pointer
        int result = -1;    // Store the index of the first occurrence
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            
            if (arr[mid] == x) {
                result = mid;   // Update the result if x is found
                right = mid - 1; // Search in the left half for the first occurrence
            } else if (arr[mid] < x) {
                left = mid + 1; // Move the left pointer to search in the right half
            } else {
                right = mid - 1; // Move the right pointer to search in the left half
            }
        }
        
        return result; // Return the index of the first occurrence (or -1 if not found)
    }
    
    // Function to find the last occurrence of element x in a sorted array arr of length n
    int findLastOccurrence(int[] arr, int n, int x) {
        int left = 0;       // Left pointer
        int right = n - 1;  // Right pointer
        int result = -1;    // Store the index of the last occurrence
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            
            if (arr[mid] == x) {
                result = mid;   // Update the result if x is found
                left = mid + 1; // Search in the right half for the last occurrence
            } else if (arr[mid] < x) {
                left = mid + 1; // Move the left pointer to search in the right half
            } else {
                right = mid - 1; // Move the right pointer to search in the left half
            }
        }
        
        return result; // Return the index of the last occurrence (or -1 if not found)
    }
}
