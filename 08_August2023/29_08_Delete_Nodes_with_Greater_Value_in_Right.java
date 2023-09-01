// Link: https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
//  Time Complexity: O(n)
//  Space Complexity: O(1)

class Solution
{
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
    
    // Recursive function to rearrange the list
    Node solve(Node curr) {
        if (curr == null)
            return curr;
        
        // Recursively rearrange the rest of the list
        Node last = solve(curr.next);
        
        if (last != null) {
            // If the last node has a smaller value, update the current node's next
            if (last.data <= curr.data)
                curr.next = last;
            else
                return last; // Return the last node with a larger value
        } else
            curr.next = last;
        
        return curr;
    }
    
    // Main function to rearrange the linked list
    Node compute(Node head)
    {
        return solve(head);
    }
}
