// Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
// Time Complexity: O(N * log N) where N is the number of nodes in the tree
// Space Complexity: O(N) where N is the number of nodes in the tree

import java.util.ArrayList;
import java.util.Collections;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> inorderList = new ArrayList<>();
    int index = 0;

    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root) {
        // Step 1: Perform in-order traversal to extract values
        inorderTraversal(root);

        // Step 2: Sort the values
        Collections.sort(inorderList);

        // Step 3: Create a new BST
        return constructBST(root);
    }

    // Perform in-order traversal to extract values
    void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        inorderList.add(root.data);
        inorderTraversal(root.right);
    }

    // Construct BST while reassigning values
    Node constructBST(Node root) {
        if (root == null) {
            return null;
        }
        // Recursively build the left subtree
        root.left = constructBST(root.left);

        // Assign the sorted value to the current node
        root.data = inorderList.get(index);
        index++;

        // Recursively build the right subtree
        root.right = constructBST(root.right);

        return root;
    }
}
