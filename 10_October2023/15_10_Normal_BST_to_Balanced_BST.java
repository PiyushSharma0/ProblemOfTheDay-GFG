// Link: https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GfG {
    // Function to convert a BST into a sorted array
    void storeBSTNodes(Node root, ArrayList<Node> nodes) {
        if (root == null)
            return;

        // In-order traversal to store nodes in sorted order
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    // Function to build a balanced BST from a sorted array
    Node buildBalancedTreeUtil(ArrayList<Node> nodes, int start, int end) {
        if (start > end)
            return null;

        // Middle element of the array is the root
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        // Recursively build the left and right subtrees
        node.left = buildBalancedTreeUtil(nodes, start, mid - 1);
        node.right = buildBalancedTreeUtil(nodes, mid + 1, end);

        return node;
    }

    // Main function to build a balanced BST from a given BST
    Node buildBalancedTree(Node root) {
        // Step 1: Store nodes of the BST in a sorted array
        ArrayList<Node> nodes = new ArrayList<>();
        storeBSTNodes(root, nodes);

        // Step 2: Build a balanced BST from the sorted array
        int n = nodes.size();
        return buildBalancedTreeUtil(nodes, 0, n - 1);
    }
}
