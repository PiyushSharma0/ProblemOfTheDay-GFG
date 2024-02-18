// Link: https://practice.geeksforgeeks.org/problems/sum-of-leaf-nodes-in-bst/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public static int sumOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }

        // Check if the current node is a leaf node
        if (root.left == null && root.right == null) {
            return root.data; // Return the value of the leaf node
        }

        // Recursively calculate the sum of leaf nodes in the left and right subtrees
        int leftSum = sumOfLeafNodes(root.left);
        int rightSum = sumOfLeafNodes(root.right);

        // Return the total sum of leaf nodes
        return leftSum + rightSum;
    }
}