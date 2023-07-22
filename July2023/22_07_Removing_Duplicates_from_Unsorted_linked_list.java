// Link: https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution
{
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
        if (head == null || head.next == null) {
            return head; // No duplicates in an empty or single-node list.
        }

        HashSet<Integer> encounteredValues = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (encounteredValues.contains(current.data)) {
                // Duplicate node found, remove it.
                prev.next = current.next;
            } else {
                // New unique value, add it to the set.
                encounteredValues.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}