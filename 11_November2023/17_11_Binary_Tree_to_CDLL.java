// Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1#
// Time Complexity: O(N)
// Auxiliary Space: O(H) where H is the height of the tree.

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Head and prev are class-level variables.
    // head will store the head of the circular doubly linked list.
    // prev will keep track of the previously processed node during inorder traversal.
    Node head = null, prev = null;

    // Recursive function to perform inorder traversal and convert the binary tree to CDLL.
    void inorder(Node root) {
        if (root != null) {
            // Process left subtree
            inorder(root.left);

            // If head is null, set it to the leftmost node (first node of inorder traversal)
            if (head == null) {
                head = root;
            }

            // Connect the previous node's right pointer to the current node.
            if (prev != null) {
                prev.right = root;
            }

            // Connect the current node's left pointer to the previous node.
            root.left = prev;

            // Update the prev pointer to the current node for the next iteration.
            prev = root;

            // Process right subtree
            inorder(root.right);
        }
    }

    // Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root) {
        // Check if the tree is empty.
        if (root == null) {
            return null;
        }

        // Call the inorder function to convert the binary tree to CDLL.
        inorder(root);

        // Connect the last node's right pointer to the head, and head's left pointer to the last node.
        prev.right = head;
        head.left = prev;

        // Return the head of the circular doubly linked list.
        return head;
    }
}
