// Link: https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
// Time Complexity: O(n)
// Space Complexity: O(h)

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Solution {
    int count = 0;
    int c1 = 0;

    int level(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    // Count all leaf nodes in the tree
    void find(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            count++;
        find(root.left);
        find(root.right);
    }

    // Count all nodes at the last level
    void find1(Node root, int currentLevel, int lastLevel) {
        if (root == null)
            return;
        if (currentLevel == lastLevel)
            c1++;
        find1(root.left, currentLevel + 1, lastLevel);
        find1(root.right, currentLevel + 1, lastLevel);
    }

    boolean check(Node root) {
        int treeHeight = level(root);
        find(root);
        find1(root, 1, treeHeight);

        // If the count of leaf nodes is equal to the count of nodes at the last level, return true
        return count == c1;
    }
}
