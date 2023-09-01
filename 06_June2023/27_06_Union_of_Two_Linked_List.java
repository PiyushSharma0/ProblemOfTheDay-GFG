// Link: https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1
// Time Complexity: O(nlogn) beacuse of merge sort
// Space Complexity: O(1)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Solution {
    // Merge two sorted linked lists
    public Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node smallerHead = null;

        // Compare the data of the current nodes
        if (head2.data > head1.data) {
            smallerHead = head1;
            smallerHead.next = merge(head1.next, head2);
        } else {
            smallerHead = head2;
            smallerHead.next = merge(head1, head2.next);
        }
        return smallerHead;
    }

    // Perform merge sort on a linked list
    public Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;

        // Recursively divide the linked list and merge the sorted halves
        Node sortedFirstHead = mergeSort(head);
        Node sortedSecondHead = mergeSort(secondHalf);

        return merge(sortedFirstHead, sortedSecondHead);
    }

    // Remove duplicates from a sorted linked list
    public Node removeDuplicates(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else 
                curr = curr.next;
        }
        return head;
    }

    // Make union of two linked lists in ascending order without duplicates
    public Node makeUnion(Node head1, Node head2) {
        Node mergedList = merge(head1, head2);
        Node sortedList = mergeSort(mergedList);
        
        return removeDuplicates(sortedList);
    }
}
