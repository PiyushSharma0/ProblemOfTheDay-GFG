// Link: https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

class Solution {
    public static Node reverseDLL(Node head) {
        // If the list is empty or has only one node, it is already reversed
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node temp = null;

        // Swap next and prev pointers for all nodes of the doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }

        // Update the head to point to the new first node
        head = temp.prev;

        return head;
    }
}