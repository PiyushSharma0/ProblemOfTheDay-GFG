// Link: https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution{
    Node deleteNode(Node head, int x)
    {
        // If the list is empty, return null
        if (head == null)
            return null;
        
        // If the first node needs to be deleted
        if (x == 1)
            return head.next;
        
        // Traverse to the x-1th node
        Node current = head;
        for (int i = 1; current != null && i < x - 1; i++)
            current = current.next;
        
        // If the x-1th node is null or its next is null, return the current head
        if (current == null || current.next == null)
            return head;
        
        // Update the next pointer of x-1th node to skip the xth node
        current.next = current.next.next;
        
        return head;
    }
}