// Link: https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size()) {
            // Invalid value of k
            return q;
        }

        // Create a stack to store the first K elements
        Stack<Integer> stack = new Stack<>();

        // Push the first K elements onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Enqueue the elements back into the queue in reversed order
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Enqueue the remaining elements back into the queue
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }

        return q;
    }
}
