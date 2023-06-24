// Link: https://practice.geeksforgeeks.org/problems/prefix-match-with-other-strings/1
// Time Complexity: O(N * K) where N is the number of strings in the array and K is the length of the string
// Space Complexity: O(1) as no extra space is used

class Solution {
    public int klengthpref(String[] arr, int n, int k, String str) {
        int count = 0; // Variable to store the count of matching strings
        
        for (String s : arr) { // Iterate through each string s in arr[]
            if (s.length() >= k && str.length() >= k && s.substring(0, k).equals(str.substring(0, k))) {
                // Check if the length of s and str is at least k
                // Compare the substring of s from index 0 to k with the substring of str from index 0 to k
                if (s.substring(0, k).equals(str.substring(0, k))) {
                    count++; // Increment the count if the substrings match
                }
            }
        }
        
        return count; // Return the count of matching strings
    }
}
