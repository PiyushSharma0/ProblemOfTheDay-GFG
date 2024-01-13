// Link: https://www.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Solution
{
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertionSort(Node head_ref) {
        // If the list is empty or has only one node, it is already sorted
        if (head_ref == null || head_ref.next == null) {
            return head_ref;
        }

        Node sortedList = null;
        Node current = head_ref;

        while (current != null) {
            Node next = current.next;
            sortedList = sortedInsert(sortedList, current);
            current = next;
        }

        return sortedList;
    }

    private static Node sortedInsert(Node sortedList, Node newNode) {
        if (sortedList == null || sortedList.data >= newNode.data) {
            newNode.next = sortedList;
            return newNode;
        }

        Node current = sortedList;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return sortedList;
    }
}
