// Link: https://practice.geeksforgeeks.org/problems/queue-reversal/1/
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.Queue;
import java.util.Stack;

class Solution {
    // Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all elements from the queue into the stack.
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        
        // Push all elements from the stack back into the queue.
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        return q;
    }
}
