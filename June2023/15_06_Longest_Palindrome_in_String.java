// Link: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
// Time Complexity: O(N^2) where N is the length of the string
// Space Complexity: O(1)

class Solution {
    public String longestPalin(String s) {
        int n = s.length();
        int start = n;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Odd case: Expand around the current character as the center
            int l = i - 1; // Left pointer
            int r = i + 1; // Right pointer
            int cans = 1; // Length of current palindrome

            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                cans += 2;
                r++;
                l--;
            }

            // Update longest palindrome if current length is greater
            if (cans > ans) {
                ans = cans;
                start = l + 1;
            } else if (cans == ans && l + 1 < start) {
                // In case of conflict, update the starting index if it is smaller
                start = l + 1;
            }

            // Even case: Expand around the current character and its right neighbor as the center
            l = i - 1; // Reset left pointer
            r = i; // Reset right pointer
            cans = 0; // Reset current palindrome length

            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                cans += 2;
                r++;
                l--;
            }

            // Update longest palindrome if current length is greater
            if (cans > ans) {
                ans = cans;
                start = l + 1;
            } else if (cans == ans && l + 1 < start) {
                // In case of conflict, update the starting index if it is smaller
                start = l + 1;
            }
        }

        return s.substring(start, start + ans); // Return the longest palindromic substring
    }
}
