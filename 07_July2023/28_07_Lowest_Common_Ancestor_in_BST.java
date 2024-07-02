// Link: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
// Time Complexity: O(h) where h is the height of the BST.
// Space Complexity: O(h) where h is the height of the BST.

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // If both nodes lie in the left subtree, move to the left subtree.
        if (root.data > n1 && root.data > n2) {
            return LCA(root.left, n1, n2);
        }

        // If both nodes lie in the right subtree, move to the right subtree.
        if (root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        }

        // If one node lies in the left subtree and the other in the right subtree,
        // or one of them is equal to the current node's value (LCA found).
        return root;
    }
}