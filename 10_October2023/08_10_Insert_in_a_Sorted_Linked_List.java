// Link: https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    Node sortedInsert(Node head1, int key) {
        // Create a new node with the given key
        Node newNode = new Node(key);

        // If the linked list is empty or the key is smaller than the head node's value
        // Insert the new node at the beginning
        if (head1 == null || key < head1.data) {
            newNode.next = head1;
            return newNode;
        }

        // Traverse the linked list to find the correct position
        Node current = head1;
        while (current.next != null && current.next.data < key) {
            current = current.next;
        }

        // Insert the new node at the correct position
        newNode.next = current.next;
        current.next = newNode;

        return head1;
    }
}
