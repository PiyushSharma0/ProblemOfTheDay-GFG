// Link: https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/
// Time Complexity: O(N)
// Space Complexity: O(1)

class Node {
    int data;
    Node next;
    
    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        // If the list is empty or has only one node, no swapping is needed.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize the previous and current nodes for swapping.
        Node prev = null;
        Node current = head;
        
        // Traverse the list and swap nodes pairwise.
        while (current != null && current.next != null) {
            Node nextNode = current.next;
            
            // Swap the nodes
            current.next = nextNode.next;
            nextNode.next = current;
            
            // Update the previous node's next pointer
            if (prev == null) {
                head = nextNode; // Update the head if we are at the beginning.
            } else {
                prev.next = nextNode;
            }
            
            // Move to the next pair
            prev = current;
            current = current.next;
        }
        
        return head;
    }
}
