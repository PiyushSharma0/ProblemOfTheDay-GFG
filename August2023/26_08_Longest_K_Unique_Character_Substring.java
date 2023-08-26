// Link: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(k) where k is the number of unique characters

import java.util.*;

class Solution {
    public int longestkSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0)
            return -1;

        // HashMap to store the count of each character in the current window
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Variable to keep track of the maximum length of valid substring
        int maxLength = -1;
        
        // Left pointer of the sliding window
        int left = 0;

        // Iterate through the string using the sliding window technique
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            // Increment the count of the current character in the hashmap
            charCount.put(rChar, charCount.getOrDefault(rChar, 0) + 1);

            // Reduce the size of the window if the number of unique characters exceeds k
            while (charCount.size() > k) {
                char lChar = s.charAt(left);
                charCount.put(lChar, charCount.get(lChar) - 1);
                // Remove characters with count 0 to maintain the count of unique characters
                if (charCount.get(lChar) == 0) {
                    charCount.remove(lChar);
                }
                // Move the left pointer to shrink the window
                left++;
            }

            // Check if the current window has exactly k unique characters
            if (charCount.size() == k) {
                // Update the maxLength if the current window length is greater
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
