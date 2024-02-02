// Link: https://www.geeksforgeeks.org/problems/implement-atoi/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    int atoi(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int result = 0;
        int i = 0;
        int n = s.length();
        boolean isNegative = false;

        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = (s.charAt(i) == '-');
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return -1;
            }

            result = result * 10 + digit;
            i++;
        }

        // Check for additional characters after the numeric part
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i < n) {
            return -1; // There are non-numeric characters after the numeric part
        }

        return isNegative ? -result : result;
    }
}
