// Link: https://practice.geeksforgeeks.org/problems/largest-bst/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public static class Gnode {
        int min;
        int max;
        int val;

        Gnode(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }

    public static Gnode func(Node root) {

        if (root == null) {
            return new Gnode(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Gnode left = func(root.left);
        Gnode right = func(root.right);

        if (left.max < root.data && root.data < right.min) {
            return new Gnode(Math.min(left.min, root.data), Math.max(right.max, root.data), left.val + right.val + 1);
        }

        return new Gnode(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.val, right.val));

    }

    static int largestBst(Node root) {
        return func(root).val;
    }
}