// Link: https://practice.geeksforgeeks.org/problems/maximum-depth-of-binary-tree/1
// Time Complexity: O(n) because we are visiting each node exactly once
// Space Complexity: O(n) because of the recursion stack

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
  public static int maxDepth(Node root) {
    if (root == null)
      return 0;

    // Find the depth of the left subtree
    int leftDepth = maxDepth(root.left);
    // Find the depth of the right subtree
    int rightDepth = maxDepth(root.right);

    // Return the maximum of the two depths
    return Math.max(leftDepth, rightDepth) + 1;
  }
}