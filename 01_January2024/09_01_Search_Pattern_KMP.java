// Link: https://practice.geeksforgeeks.org/problems/search-pattern0205/1#
// Time Complexity: O(N + M)
// Space Complexity: O(N + M)

class Solution {
    
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Concatenate the pattern and text with a special character (e.g., '#')
        String concatenatedString = pat + "#" + txt;
        
        // Calculate the prefix array using the KMP algorithm
        int[] lps = calculateLPS(concatenatedString);
        
        // Iterate through the lps array to find occurrences of the pattern in the text
        for (int i = pat.length() + 1; i < concatenatedString.length(); i++) {
            if (lps[i] == pat.length()) {
                // Pattern found at index i - 2 * pat.length() (1-based index)
                result.add(i - 2 * pat.length() + 1);
            }
        }
        
        return result;
    }
    
    // Function to calculate the Longest Prefix Suffix (LPS) array using the KMP algorithm
    private int[] calculateLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the longest prefix suffix
        
        for (int i = 1; i < n; ) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
