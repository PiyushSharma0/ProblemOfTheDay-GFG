//Link: https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
// Time Complexity: O(N) where N is the number of elements in the stack
// Space Complexity: O(N) where N is the number of elements in the stack

import java.util.Stack;

class Solution
{
    // Function to reverse a stack using recursion
    static void reverse(Stack<Integer> s)
    {
        if (!s.isEmpty()) {
            // Pop an element from the stack
            int temp = s.pop();

            // Recursively reverse the remaining elements in the stack
            reverse(s);

            // Insert the popped element at the bottom of the reversed stack
            insertAtBottom(s, temp);
        }
    }

    // Function to insert an element at the bottom of a stack using recursion
    static void insertAtBottom(Stack<Integer> s, int value)
    {
        if (s.isEmpty()) {
            // If the stack is empty, push the value to the stack
            s.push(value);
        } else {
            // Pop an element from the stack
            int temp = s.pop();

            // Recursively insert the value at the bottom of the remaining stack
            insertAtBottom(s, value);

            // Push the popped element back onto the stack
            s.push(temp);
        }
    }
}
