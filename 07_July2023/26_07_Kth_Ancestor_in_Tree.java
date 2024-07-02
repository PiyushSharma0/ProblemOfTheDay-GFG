// Link: https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class Solution {
    private int out;

    public int kthAncestor(Node root, int k, int node) {
        out = -1;
        findAncestor(root, k, node);
        return out;
    }

    private int findAncestor(Node root, int k, int node) {
        // Base case: If the current node is null, return k-1.
        if (root == null)
            return k - 1;

        // If the current node is the target node, return k-1.
        if (root.data == node)
            return k - 1;

        // Initialize newK to maximum integer value.
        int newK = Integer.MAX_VALUE;
        
        // Recursively search in the left subtree and update newK.
        if (root.left != null) {
            newK = findAncestor(root.left, k, node);
        }
        
        // Recursively search in the right subtree and update newK.
        if (root.right != null) {
            newK = Math.min(newK, findAncestor(root.right, k, node));
        }

        // If newK is 0, it means we have found the kth ancestor of the target node.
        // Update 'out' with the data of the current node.
        if (newK == 0) {
            out = root.data;
        }

        // Return newK - 1, which decrements the remaining distance to the target node.
        return newK - 1;
    }
}