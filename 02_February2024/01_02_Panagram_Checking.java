// Link: https://practice.geeksforgeeks.org/problems/pangram-checking-1587115620/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    // Function to check if a string is a Pangram or not.
    public static boolean checkPangram(String s) {
        // Create a boolean array to track the occurrence of each letter
        boolean[] alphabetOccurrence = new boolean[26];

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if the character is an English alphabet letter
            if ('A' <= c && c <= 'Z') {
                alphabetOccurrence[c - 'A'] = true;
            } else if ('a' <= c && c <= 'z') {
                alphabetOccurrence[c - 'a'] = true;
            }
        }

        // Check if all letters in the alphabet have occurred at least once
        for (boolean letterOccurred : alphabetOccurrence) {
            if (!letterOccurred) {
                return false;
            }
        }

        // If all letters have occurred, it is a Pangram
        return true;
    }
}
