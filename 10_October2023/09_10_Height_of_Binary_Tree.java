// Link: https://practice.geeksforgeeks.org/problems/height-of-binary-tree/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // Base case: If the tree is empty (null), its height is 0.
        if (node == null) {
            return 0;
        }
        
        // Recursively calculate the height of the left and right subtrees.
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // Return the maximum height of the left and right subtrees, plus 1 (for the current node).
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
