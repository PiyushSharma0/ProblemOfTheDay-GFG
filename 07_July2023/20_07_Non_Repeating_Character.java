// Link: https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/
// Time Complexity: O(N)
// Space Complexity: O(1) // Since the size of the array is fixed (26)

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        int[] charCount = new int[26];

        // Counting the occurrence of each character in the string.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            charCount[ch - 'a']++;
        }

        // Finding the first non-repeating character in the string.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (charCount[ch - 'a'] == 1) {
                return ch; // First non-repeating character found.
            }
        }

        // If there's no non-repeating character, return '$' as per the requirement.
        return '$';
    }
}