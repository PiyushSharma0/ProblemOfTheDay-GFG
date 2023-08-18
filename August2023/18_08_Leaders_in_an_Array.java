// Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // The rightmost element is always a leader.
        int maxRight = arr[n - 1];
        result.add(maxRight);
        
        // Traverse the array from right to left and keep track of the maximum element.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                result.add(maxRight);
            }
        }
        
        // Reverse the result to get the leaders in the original order.
        int left = 0;
        int right = result.size() - 1;
        while (left < right) {
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            left++;
            right--;
        }
        
        return result;
    }
}