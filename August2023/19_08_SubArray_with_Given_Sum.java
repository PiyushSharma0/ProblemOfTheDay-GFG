// Link: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution
{
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        int left = 0; // Initialize left pointer
        int right = 0; // Initialize right pointer
        int currentSum = 0; // Initialize current sum
        
        while (right < n) {
            currentSum += arr[right]; // Add the current element to the current sum
            
            // If the current sum exceeds the given sum, move the left pointer
            while (currentSum > s) {
                currentSum -= arr[left];
                left++;
            }
            
            // If the current sum equals the given sum, return the subarray indexes
            if (currentSum == s) {
                result.add(left + 1); // Add 1 to convert from 0-based index to 1-based index
                result.add(right + 1);
                return result;
            }
            
            right++; // Move the right pointer to the next element
        }
        
        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }
}