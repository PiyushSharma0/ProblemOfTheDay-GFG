// Link: https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
// Time Complexity: O(N)
// Space Complexity: O(1)

static int minDiff(Node root, int K) {
    if (root == null)
        return Integer.MAX_VALUE;

    // In-order traversal
    int minDiff = Integer.MAX_VALUE;
    Node curr = root;
    Node prev = null;

    while (curr != null) {
        if (curr.left == null) {
            minDiff = Math.min(minDiff, Math.abs(curr.data - K));
            curr = curr.right;
        } else {
           prev = curr.left;
           while (prev.right != null && prev.right != curr)
            prev = prev.right;
            if (prev.right == null) {
               prev.right = curr;
               curr = curr.left;
           } else {
               prev.right = null;
               minDiff = Math.min(minDiff, Math.abs(curr.data - K));
               curr = curr.right;
           }
        }
    }
    return minDiff;
    }
}