class Solution {
    // Definition for a binary tree node.
    class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        // If the tree is empty, create a new node and return it as the new root.
        if (root == null) {
            root = new Node(Key);
            return root;
        }

        // If the key is less than the root's data, recursively insert into the left subtree.
        if (Key < root.data) {
            root.left = insert(root.left, Key);
        }
        // If the key is greater than the root's data, recursively insert into the right subtree.
        else if (Key > root.data) {
            root.right = insert(root.right, Key);
        }

        // Return the (unchanged) node pointer.
        return root;
    }
}
