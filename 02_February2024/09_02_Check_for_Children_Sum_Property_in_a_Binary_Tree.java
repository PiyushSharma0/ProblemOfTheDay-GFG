// Link: https://www.geeksforgeeks.org/problems/children-sum-parent/1
// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree

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

class Solution
{
    // Helper function to check whether a node satisfies the sum property
    private static boolean isSumPropertyUtil(Node node) {
        // Base case: if the node is null, it satisfies the property
        if (node == null) {
            return true;
        }

        // If the node is a leaf, it automatically satisfies the property
        if (node.left == null && node.right == null) {
            return true;
        }

        // Calculate the sum of left and right children's values
        int leftValue = (node.left != null) ? node.left.data : 0;
        int rightValue = (node.right != null) ? node.right.data : 0;

        // Recursively check the sum property for left and right subtrees
        boolean leftSatisfies = isSumPropertyUtil(node.left);
        boolean rightSatisfies = isSumPropertyUtil(node.right);

        // Check if the current node satisfies the sum property
        return (node.data == leftValue + rightValue) && leftSatisfies && rightSatisfies;
    }

    // Function to check whether all nodes of a tree have the value 
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // Check if the root node satisfies the sum property
        return (isSumPropertyUtil(root)) ? 1 : 0;
    }
}