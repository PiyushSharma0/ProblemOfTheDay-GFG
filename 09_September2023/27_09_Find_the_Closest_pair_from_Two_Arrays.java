// Link: https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays/
// Time Complexity: O(n + m)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    // Function to find the closest pair of elements from two arrays
    // whose sum is closest to a given number x
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        // Initialize an ArrayList to store the result
        ArrayList<Integer> out = new ArrayList<>();
        // Initialize a variable to keep track of the minimum absolute difference
        int minAbsDiff = Integer.MAX_VALUE;

        // Initialize two pointers, one for each array
        int a = 0, b = m - 1;
        
        // Traverse the arrays using two pointers
        while (a < n && b >= 0) {
            // Calculate the sum of the current elements from both arrays
            int sum = arr[a] + brr[b];
            
            // Calculate the absolute difference between the sum and x
            int absDiff = Math.abs(sum - x);
            
            // Check if the current pair has a smaller absolute difference
            // If yes, update the result ArrayList and minAbsDiff
            if (absDiff < minAbsDiff) {
                out.clear(); // Clear the previous result
                out.add(arr[a]);
                out.add(brr[b]);
                minAbsDiff = absDiff; // Update the minimum absolute difference
            }
            
            // Move the pointers based on the sum
            if (sum > x)
                --b; // Decrease the pointer for the second array
            else
                ++a; // Increase the pointer for the first array
        }
        
        // Return the result ArrayList containing the closest pair
        return out;
    }
}