// Link: https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.Stack;

class Solution {
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        Stack<Integer> newStack = new Stack<>();
        int cnt = sizeOfStack / 2; // Number of elements present on the top of the middle element

        // Move elements from the original stack to newStack until reaching the middle element
        while (cnt-- > 0) {
            newStack.push(s.pop()); // Pop element from s and push it to newStack
        }

        s.pop(); // Remove the middle element

        // Restore the original order by pushing elements from newStack back to s
        while (!newStack.empty()) {
            s.push(newStack.pop()); // Pop element from newStack and push it to s
        }
    }
}
