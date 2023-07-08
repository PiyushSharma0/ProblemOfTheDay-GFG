// Link: https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public boolean findTriplets(int arr[], int n) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Iterate through the array up to the third-to-last element
        for (int i = 0; i < n - 2; i++) {
            // Check if there exist two elements whose sum is equal to the negation of the current element
            if (twoSum(arr, -arr[i], i + 1)) {
                return true; // Triplet found, return true
            }
        }
        
        return false; // No triplet found, return false
    }

    // Function to find two elements whose sum is equal to the given target
    public boolean twoSum(int[] arr, int x, int i) {
        int j = arr.length - 1; // Initialize j as the index of the last element
        
        while (i < j) {
            if (arr[i] + arr[j] > x) {
                j--; // Decrease j if the sum is greater than the target
            } else if (arr[i] + arr[j] < x) {
                i++; // Increase i if the sum is smaller than the target
            } else {
                return true; // Return true if the sum is equal to the target
            }
        }
        
        return false; // No two elements found, return false
    }
}
