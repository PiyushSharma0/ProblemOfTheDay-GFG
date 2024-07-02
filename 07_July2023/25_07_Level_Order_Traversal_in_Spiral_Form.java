// Link: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Spiral
{
    // Function to return a list containing the level order traversal in spiral form.
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Create a queue for level order traversal and a stack for reversing nodes' values.
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        // Add the root node to the queue and set the level to 0.
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) 
        {
            int size = queue.size();

            // Traverse the nodes at the current level.
            for (int i = 0; i < size; i++) 
            {
                Node node = queue.poll();

                // If the current level is even, add the node's value to the stack.
                if (level % 2 == 0) 
                {
                    stack.push(node.data);
                }
                // If the current level is odd, add the node's value to the result list.
                else 
                {
                    result.add(node.data);
                }

                // Add the left and right children of the node to the queue.
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse the values of nodes on even levels and add them to the result list.
            if (level % 2 == 0) 
            {
                while (!stack.isEmpty()) 
                {
                    result.add(stack.pop());
                }
            }
            
            // Increment the level for the next iteration.
            level++;
        }

        return result;
    }
}
