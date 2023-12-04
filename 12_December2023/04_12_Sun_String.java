// Link: https://practice.geeksforgeeks.org/problems/sum-string/1#
// Time Complexity: O(n^3)
// Space Complexity: O(n)

class Solution {
    // Helper function to add two strings representing numbers
    public String add(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder res = new StringBuilder();

        // Perform addition digit by digit
        while (i >= 0 && j >= 0) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            res.append((char) ((sum % 10) + '0'));
            carry = sum / 10;
            --i;
            --j;
        }

        // Process remaining digits in num1
        while (i >= 0) {
            int sum = (num1.charAt(i) - '0') + carry;
            res.append((char) ((sum % 10) + '0'));
            carry = sum / 10;
            --i;
        }

        // Process remaining digits in num2
        while (j >= 0) {
            int sum = (num2.charAt(j) - '0') + carry;
            res.append((char) ((sum % 10) + '0'));
            carry = sum / 10;
            --j;
        }

        // If there is a remaining carry, append it
        if (carry != 0) {
            res.append((char) (carry + '0'));
        }

        // Reverse the result and convert to string
        return res.reverse().toString();
    }

    // Recursive function to check if the string is a 'sum-string'
    public boolean solve(String s, int i, int j, int k) {
        // Extract substrings
        String num1 = s.substring(i, j);
        String num2 = s.substring(j, k);
        
        // Calculate sum of num1 and num2
        String sum = add(num1, num2);

        int n = sum.length();
        int len = k + n;

        // If the calculated sum exceeds the remaining length of the string, it's not a 'sum-string'
        if (len > s.length()) {
            return false;
        }

        // Extract the current sum from the original string
        String currSum = s.substring(k, len);

        // If the current sum doesn't match the calculated sum, it's not a 'sum-string'
        if (!currSum.equals(sum)) {
            return false;
        }

        // If the end of the string is reached, it's a 'sum-string'
        if (len == s.length()) {
            return true;
        }

        // Recursively check for the remaining part of the string
        return solve(s, j, k, len);
    }

    // Function to check if the given string is a 'sum-string'
    public int isSumString(String s) {
        int n = s.length();

        // Iterate through all possible pairs of indices
        for (int j = 1; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                // If the current pair forms a 'sum-string', return 1
                if (solve(s, 0, j, k)) {
                    return 1;
                }
            }
        }

        // If no 'sum-string' is found, return 0
        return 0;
    }
}
