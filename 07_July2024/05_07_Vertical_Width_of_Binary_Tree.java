// Link: https://practice.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    int min = 0;
    int max = 0;

    public int verticalWidth(Node root) {
        if (root == null)
            return 0;
        helper(root, 0);
        return (max - min) + 1;
    }

    private void helper(Node root, int l) {
        if (root == null)
            return;
        min = Math.min(l, min);
        max = Math.max(max, l);
        helper(root.left, l - 1);
        helper(root.right, l + 1);
    }
}