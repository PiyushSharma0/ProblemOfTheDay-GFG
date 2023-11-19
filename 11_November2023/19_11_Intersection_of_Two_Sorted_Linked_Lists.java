// Link: https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
// Time Complexity: O(m + n)
// Space Complexity: O(1)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution{
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0); // Dummy node to simplify code
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                current.next = new Node(head1.data);
                current = current.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return dummy.next; // Skip the dummy node
    }
}