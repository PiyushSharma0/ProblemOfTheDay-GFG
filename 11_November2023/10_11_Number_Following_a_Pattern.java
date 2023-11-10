// Link: https://practice.geeksforgeeks.org/problems/number-following-a-pattern/0/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    static String printMinNumberForPattern(String S) {
        int n = S.length();
        if (n == 0) return "";

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        // Loop through the pattern
        for (int i = 0; i <= n; i++) {
            stack.push(i + 1); // Push the current number

            if (i == n || S.charAt(i) == 'I') {
                // If the current character is 'I' or we have reached the end of the pattern
                // Pop all the numbers from the stack and append them to the result
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
