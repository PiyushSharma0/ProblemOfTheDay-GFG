// Link: https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public String colName(long n) {
        StringBuilder out = new StringBuilder();
        char[] code = new char[26];

        // Initialize the code array to represent letters A to Z
        for (int i = 1; i < 26; ++i) {
            code[i] = (char)('A' + i - 1);
        }
        code[0] = 'Z';

        while (n > 0) {
            // Append the corresponding letter to the result string
            out.append(code[(int)(n % 26)]);

            // If n % 26 is 0, decrement n to handle the 'Z' case
            if (n % 26 == 0) {
                --n;
            }

            // Divide n by 26 to move to the next character
            n /= 26;
        }

        // Reverse the result string
        return out.reverse().toString();
    }
}