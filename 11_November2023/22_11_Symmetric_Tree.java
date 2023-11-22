// Link: https://practice.geeksforgeeks.org/problems/symmetric-tree/1
// Time Complexity: O(n)
// Space Complexity: O(n)

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

class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        
        return isMirror(root.left, root.right);
    }

    // Helper method to check if two subtrees are mirrors of each other
    private static boolean isMirror(Node left, Node right) {
        // If both subtrees are empty, they are mirrors
        if (left == null && right == null) {
            return true;
        }

        // If one subtree is empty and the other is not, they are not mirrors
        if (left == null || right == null) {
            return false;
        }

        // Check if the values of corresponding nodes are the same
        // and if the left subtree of the left node is a mirror of the right subtree of the right node
        // and if the right subtree of the left node is a mirror of the left subtree of the right node
        return (left.data == right.data)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
