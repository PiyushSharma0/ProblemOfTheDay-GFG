// Link: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
// Time Complexity: O(N) where N is the number of nodes in the tree
// Space Complexity: O(H) where H is the height of the tree

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Tree
{
    // Function to calculate the height of a binary tree
    int height(Node node)
    {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if (root == null)
            return true;

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the left and right subtrees are balanced
        boolean leftIsBalanced = isBalanced(root.left);
        boolean rightIsBalanced = isBalanced(root.right);

        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) <= 1 && leftIsBalanced && rightIsBalanced)
        {
            return true;
        }

        return false;
    }
}
