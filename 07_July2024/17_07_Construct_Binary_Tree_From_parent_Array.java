// Link: https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Solution {
    public Node createTree(int parent[]) {
        int n = parent.length;
        Node temp[] = new Node[n];
        for(int i=0; i<n; i++){
            temp[i] = new Node(i);
        }
        Node head = null;
        for(int i=0; i<n; i++){
            if(parent[i]!=-1){
                if(temp[parent[i]].left == null){
                    temp[parent[i]].left = temp[i];
                }
                else{
                    temp[parent[i]].right = temp[i];
                }
            }
            else{
                head = temp[i];
            }
        }
        return head;
    }
}
