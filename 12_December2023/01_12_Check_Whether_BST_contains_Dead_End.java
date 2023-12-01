// Link: https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1#
// Time Complexity: O(N)
// Space Complexity: O(N)

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution
{
    // Main function to check if the BST has a dead end
    public static boolean isDeadEnd(Node root)
    {
        // Call the helper function with initial range (1, Integer.MAX_VALUE)
        return isDeadEndHelper(root, 1, Integer.MAX_VALUE);
    }

    // Helper function to recursively check for dead ends in the BST
    public static boolean isDeadEndHelper(Node node, int min, int max)
    {
        // If the current node is null, it doesn't contribute to a dead end
        if (node == null)
            return false;

        // If the range becomes a single value, it indicates a dead end
        if (min == max)
            return true;

        // Recursively check the left and right subtrees with updated ranges
        // Left subtree can have values in the range [min, node.data - 1]
        // Right subtree can have values in the range [node.data + 1, max]
        return isDeadEndHelper(node.left, min, node.data - 1) || isDeadEndHelper(node.right, node.data + 1, max);
    }
}
