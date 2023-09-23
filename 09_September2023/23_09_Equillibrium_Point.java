// Link: https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            // If there's only one element, it is always an equilibrium point.
            return 1;
        }

        long totalSum = 0; // Sum of all elements in the array
        long leftSum = 0;  // Sum of elements to the left of the current element
        
        // Calculate the total sum of all elements in the array.
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            // Update totalSum to exclude the current element.
            totalSum -= arr[i];
            
            // Check if the sum of elements before and after the current element is equal.
            if (leftSum == totalSum) {
                // Equilibrium point found, return 1-based index.
                return i + 1;
            }
            
            // Update the leftSum to include the current element.
            leftSum += arr[i];
        }

        // If no equilibrium point is found, return -1.
        return -1;
    }
}
