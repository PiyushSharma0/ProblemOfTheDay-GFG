// Link: https://practice.geeksforgeeks.org/problems/remove-half-nodes/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public Node RemoveHalfNodes(Node root) {
        if(root == null){
            return null;
        }
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        if(root.left == null && root.right!=null){
            return root.right;
        }
        else if(root.left !=null && root.right == null){
            return root.left;
        }
        return root;
    }
}