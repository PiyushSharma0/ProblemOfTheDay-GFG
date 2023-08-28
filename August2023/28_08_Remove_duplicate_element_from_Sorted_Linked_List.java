// Link: https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class GfG
{
    // Definition for singly-linked list.
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        Node current = head;
        
        while (current != null && current.next != null)
        {
            if (current.data == current.next.data)
            {
                current.next = current.next.next; // Skip the duplicate node
            }
            else
            {
                current = current.next; // Move to the next node
            }
        }
        
        return head;
    }
}
