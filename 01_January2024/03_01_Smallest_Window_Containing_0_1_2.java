// Link: https://practice.geeksforgeeks.org/problems/smallest-window-containing-1s0206/1#
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int smallestSubstring(String S) {
        int n = S.length();
        
        // Initialize a frequency array to keep track of characters in the current window
        int[] count = new int[3];
        
        // Variables to keep track of the start and end of the sliding window
        int start = 0;
        int end = 0;
        
        // Variable to keep track of the minimum length of substring containing all three characters
        int minLen = Integer.MAX_VALUE;
        
        // Variable to keep track of the count of characters in the current window
        int charCount = 0;
        
        // Iterate through the string
        while (end < n) {
            // Expand the window by including the character at the end index
            count[S.charAt(end) - '0']++;
            
            // If the count of the character becomes 1, it means it is present in the current window
            if (count[S.charAt(end) - '0'] == 1) {
                charCount++;
            }
            
            // If all three characters are present in the current window, try to minimize the window
            while (charCount == 3) {
                // Update the minimum length of substring
                minLen = Math.min(minLen, end - start + 1);
                
                // Shrink the window by excluding the character at the start index
                count[S.charAt(start) - '0']--;
                
                // If the count becomes 0, decrement the charCount as the character is no longer present in the window
                if (count[S.charAt(start) - '0'] == 0) {
                    charCount--;
                }
                
                // Move the start index ahead
                start++;
            }
            
            // Move the end index ahead
            end++;
        }
        
        // If no valid substring is found, return -1
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
