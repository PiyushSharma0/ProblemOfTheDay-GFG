// Link: https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
// Time Complexity: O(h) where h is the height of the BST
// Space Complexity: O(1)

class Solution{
    public Node inorderSuccessor(Node root, Node x)
    {
        if (x.right != null) {
            // Case 1: If the right subtree is not NULL,
            // find the leftmost node in the right subtree.
            Node current = x.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            // Case 2: If the right subtree is NULL,
            // find the deepest ancestor for which x is in the left subtree.
            Node successor = null;
            Node ancestor = root;

            while (ancestor != x) {
                if (x.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }

            return successor;
        }
    }
}