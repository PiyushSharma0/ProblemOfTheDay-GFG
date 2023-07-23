// Link: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
// Time Complexity: O(n)
// Space Complexity: O(1)

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
    // Helper function to swap two nodes in the linked list.
    static void swapNodes(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head)
    {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, no need to sort.
        }

        Node zeroTail = new Node(-1); // Dummy node to track the tail of 0s.
        Node oneTail = new Node(-1); // Dummy node to track the tail of 1s.
        Node twoTail = new Node(-1); // Dummy node to track the tail of 2s.

        Node zeroEnd = zeroTail;
        Node oneEnd = oneTail;
        Node twoEnd = twoTail;

        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zeroEnd.next = current;
                zeroEnd = zeroEnd.next;
            } else if (current.data == 1) {
                oneEnd.next = current;
                oneEnd = oneEnd.next;
            } else {
                twoEnd.next = current;
                twoEnd = twoEnd.next;
            }
            current = current.next;
        }

        // Connect the tail of each segment to the head of the next segment.
        zeroEnd.next = oneTail.next != null ? oneTail.next : twoTail.next;
        oneEnd.next = twoTail.next;

        // Update the next of the tail node of the 2s segment to null.
        twoEnd.next = null;

        // Return the head of the sorted linked list.
        return zeroTail.next;
    }
}
