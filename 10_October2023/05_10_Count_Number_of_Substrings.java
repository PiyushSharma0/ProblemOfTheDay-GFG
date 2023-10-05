// Link: https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1#
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    // Function to count substrings with exactly k distinct characters
    long substrCount(String s, int k) {
        // Calculate the count of substrings with at most k distinct characters
        // and subtract the count of substrings with at most k-1 distinct characters
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    // Function to count substrings with at most k distinct characters
    long countAtMostK(String s, int k) {
        long cnt = 0;
        // Frequency array to store the count of each character in the current window
        int[] freq = new int[26];
        int i = 0; // Left pointer of the window
        int diff = 0; // Count of distinct characters in the current window

        for (int j = 0; j < s.length(); ++j) {
            // Check if the character at index j is a new distinct character
            if (freq[s.charAt(j) - 'a'] == 0)
                ++diff;
            ++freq[s.charAt(j) - 'a'];

            // If the number of distinct characters exceeds k, move the left pointer
            while (diff > k && i <= j) {
                --freq[s.charAt(i) - 'a'];
                // If a character's count becomes 0, decrement the distinct character count
                if (freq[s.charAt(i) - 'a'] == 0)
                    --diff;
                ++i;
            }

            // Add the count of substrings with at most k distinct characters ending at index j
            cnt += j - i + 1;
        }

        return cnt;
    }
}
