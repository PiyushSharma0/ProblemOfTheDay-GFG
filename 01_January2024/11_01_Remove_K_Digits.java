// Link: https://leetcode.com/problems/remove-k-digits/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;

class Solution {
    public String removeKdigits(String S, int K) {
        int n = S.length();
        
        // If the number of digits to be removed is equal to the length of the number,
        // then the result will be an empty string (no digits left).
        if (K == n) {
            return "0";
        }
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char digit : S.toCharArray()) {
            // Pop elements from the stack as long as the current digit is smaller
            // and there are still digits to be removed.
            while (K > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                K--;
            }
            stack.addLast(digit);
        }
        
        // If there are still digits to be removed, pop from the stack.
        while (K > 0) {
            stack.removeLast();
            K--;
        }
        
        // Build the result string directly from the stack.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeFirst());
        }
        
        // Remove leading zeros.
        int nonZeroIndex = 0;
        while (nonZeroIndex < result.length() && result.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        
        return (nonZeroIndex == result.length()) ? "0" : result.substring(nonZeroIndex);
    }
}
