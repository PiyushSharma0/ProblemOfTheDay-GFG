// Link: https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/
// Time Complexity: O(m + n) where m and n are the number of nodes in the two BSTs respectively.
// Space Complexity: O(h1 + h2) where h1 and h2 are the heights of the two BSTs respectively.

import java.util.ArrayList;
import java.util.Stack;

class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution
{
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Traverse the BSTs in-order using stacks
        while (!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null)
        {
            // Traverse the left subtree as far as possible
            while (root1 != null)
            {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null)
            {
                stack2.push(root2);
                root2 = root2.left;
            }

            // Compare the current nodes
            if (!stack1.isEmpty() && !stack2.isEmpty())
            {
                root1 = stack1.peek();
                root2 = stack2.peek();

                if (root1.data == root2.data)
                {
                    result.add(root1.data);
                    stack1.pop();
                    stack2.pop();
                    // Move to the right subtree of both BSTs
                    root1 = root1.right;
                    root2 = root2.right;
                }
                else if (root1.data < root2.data)
                {
                    stack1.pop();
                    root1 = root1.right;
                    root2 = null;
                }
                else
                {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            else
                break;
        }

        return result;
    }
}
