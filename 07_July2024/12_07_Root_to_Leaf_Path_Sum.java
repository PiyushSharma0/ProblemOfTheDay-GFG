// Link: https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    boolean hasPathSum(Node root, int target) {
        return recur(root,target,0);
    }
    boolean recur(Node root,int target,int sum){
        if(root==null){
            return false;
        }
        sum+=root.data;
        if(root.left==null&&root.right==null){
            return sum==target;
        }
        return recur(root.left,target,sum)||
               recur(root.right,target,sum);
        
    }
}