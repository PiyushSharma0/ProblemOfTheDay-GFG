// Link: https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/
// Time Complexity: O(N) where N is the number of nodes in the tree
// Space Complexity: O(H) where H is the height of the tree

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Solution {
    // Function to find nodes at a distance k from the target node
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // Create an ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        // Call the recursive function to find nodes and populate the result
        findDist(root, target, k, result);
        // Sort the result in ascending order
        result.sort(null);
        return result;
    }

    // Recursive function to find nodes at a distance k from the target node
    private static int findDist(Node node, int target, int k, ArrayList<Integer> result) {
        // Base case: If the node is null or k is negative, return -1
        if (node == null || k < 0) {
            return -1;
        }

        // If the current node contains the target value
        if (node.data == target) {
            // Call the trace function to find nodes at distance k
            trace(node, k, result);
            return k - 1; // Decrement k
        }

        // Recursively search in the left subtree
        int fromLeft = findDist(node.left, target, k, result);
        if (fromLeft != -1) {
            // If a node is found at distance k, add it to the result
            if (fromLeft == 0) {
                result.add(node.data);
            } else if (fromLeft > 0) {
                // Call the trace function for the right subtree with decremented k
                trace(node.right, fromLeft - 1, result);
            }
            // Decrement fromLeft and return it
            return fromLeft - 1;
        }

        // Recursively search in the right subtree
        int fromRight = findDist(node.right, target, k, result);
        if (fromRight != -1) {
            // If a node is found at distance k, add it to the result
            if (fromRight == 0) {
                result.add(node.data);
            } else if (fromRight > 0) {
                // Call the trace function for the left subtree with decremented k
                trace(node.left, fromRight - 1, result);
            }
            // Decrement fromRight and return it
            return fromRight - 1;
        }

        // If the target node is not found in the current subtree, return -1
        return -1;
    }

    // Recursive function to trace nodes at a distance k from the current node
    private static void trace(Node node, int k, ArrayList<Integer> result) {
        // Base case: If the node is null or k is negative, return
        if (node == null || k < 0) {
            return;
        }

        // If k becomes 0, add the current node's value to the result
        if (k == 0) {
            result.add(node.data);
            return;
        }

        // Recursively explore the left and right subtrees with decremented k
        trace(node.left, k - 1, result);
        trace(node.right, k - 1, result);
    }
}