// Link: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1
// Time Complexity: O(N*N!)
// Space Complexity: O(N*N!)

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // Function to generate permutations of a string
    public ArrayList<String> permutation(String S) {
        ArrayList<String> ans = new ArrayList<>();
        helper(S.length() - 1, ans, new StringBuilder(S)); // Start recursion
        Collections.sort(ans); // Sort the list of permutations
        return ans; // Return the sorted list of permutations
    }

    // Recursive helper function to generate permutations
    private void helper(int i, ArrayList<String> ans, StringBuilder s) {
        if (i == 0) {
            ans.add(s.toString()); // Add the current permutation to the list
            return;
        }
        for (int ind = i; ind >= 0; ind--) {
            swap(s, i, ind); // Swap characters to generate a new permutation
            helper(i - 1, ans, s); // Recursively generate permutations for the remaining characters
            swap(s, i, ind); // Restore the string to its original state for backtracking
        }
    }

    // Helper function to swap characters in a StringBuilder
    private void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}
