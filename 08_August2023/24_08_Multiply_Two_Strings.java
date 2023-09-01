// Link: https://practice.geeksforgeeks.org/problems/multiply-two-strings/1
// Time Complexity: O(n * m * l) where n and m are the number of rows and columns in the grid and l is the length of the word
// Space Complexity: O(1)

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Reverse the input strings for easier processing
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder(s2);
        sb2.reverse();
        
        // Initialize flags for negative numbers
        boolean isNeg1 = false, isNeg2 = false;

        // Check if the last character is '-' for both strings
        if (sb1.charAt(sb1.length() - 1) == '-') {
            sb1.setLength(sb1.length() - 1);
            isNeg1 = true;
        }
        if (sb2.charAt(sb2.length() - 1) == '-') {
            sb2.setLength(sb2.length() - 1);
            isNeg2 = true;
        }
        
        // Remove trailing zeros from both strings
        while (sb1.charAt(sb1.length() - 1) == '0') {
            sb1.setLength(sb1.length() - 1);
        }
        while (sb2.charAt(sb2.length() - 1) == '0') {
            sb2.setLength(sb2.length() - 1);
        }

        // Determine lengths of input strings
        int len1 = sb1.length();
        int len2 = sb2.length();

        // Initialize output StringBuilder with appropriate length
        StringBuilder out = new StringBuilder(len1 + len2);
        for (int i = 0; i < len1 + len2; ++i) {
            out.append('0');
        }

        // Multiply the digits
        for (int i = 0; i < len2; ++i) {
            int carry = 0, j;

            for (j = 0; j < len1; ++j) {
                int mul = (sb2.charAt(i) - '0') * (sb1.charAt(j) - '0') + (out.charAt(i + j) - '0') + carry;
                out.setCharAt(i + j, (char) ('0' + mul % 10));
                carry = mul / 10;
            }

            // Handle remaining carry
            while (carry > 0) {
                int mul = (out.charAt(i + j) - '0') + carry;
                out.setCharAt(i + j, (char) ('0' + mul % 10));
                carry = mul / 10;
                ++j;
            }
        }

        // Remove leading zeros from the output
        while (out.charAt(out.length() - 1) == '0') {
            out.setLength(out.length() - 1);
        }

        // Handle zero result
        if (out.length() == 0) {
            return "0";
        }

        // Handle negative result
        if (isNeg1 ^ isNeg2) {
            out.append('-');
        }

        // Reverse the output and convert to string
        return out.reverse().toString();
    }
}
