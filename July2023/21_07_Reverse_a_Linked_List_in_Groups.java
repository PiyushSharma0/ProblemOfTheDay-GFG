// Link: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
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


class Solution {
    public static Node reverse(Node head, int k)
    {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Count the number of nodes in the linked list
        while (current != null && count < k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If the number of nodes is not a multiple of k,
        // then 'current' will be pointing to the (k+1)th node
        // and 'prev' will be the new head of the reversed group.
        if (next != null)
            head.next = reverse(next, k);

        // 'prev' is the new head of the reversed group
        return prev;
    }
}