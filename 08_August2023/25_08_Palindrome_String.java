// Link: https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    int isPalindrome(String S) {
        S = S.toLowerCase(); // Convert to lowercase
        StringBuilder cleanString = new StringBuilder();
        
        // Remove non-alphanumeric characters
        for (char c : S.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanString.append(c);
            }
        }
        
        // Compare characters from both ends
        int left = 0;
        int right = cleanString.length() - 1;
        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return 0; // Not a palindrome
            }
            left++;
            right--;
        }
        
        return 1; // Palindrome
    }
}