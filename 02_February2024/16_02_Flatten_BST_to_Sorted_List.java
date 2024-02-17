// Link: https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

class Solution {
    private Node prev;

    private void inorder(Node curr) {
        if (curr == null)
            return;
        inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        inorder(curr.right);
    }

    public Node flattenBST(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;

        inorder(root);

        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;

        return ret;
    }
}