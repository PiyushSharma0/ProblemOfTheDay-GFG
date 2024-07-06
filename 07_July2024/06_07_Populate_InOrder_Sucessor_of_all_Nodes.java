// Link: https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Node {
    int data;
    Node left, right, next;
    Node(int key) {
        data = key;
        left = right = next = null;
    }
}

class Solution {
    public void populateNext(Node root) {
        // code here
        List<Node> li = new ArrayList<>();
        addNode(root,li);
        
        Node temp = new Node(-1);
        li.add(temp);
        
        for(int i = 0;i<li.size()-2;i++){
           li.get(i).next = li.get(i+1);
        }
        
    }
    
    public Node addNode(Node node, List<Node> li){
        if(node == null) return null;
        
        addNode(node.left,li);
        li.add(node);
        addNode(node.right,li);
    return null;
    }
}