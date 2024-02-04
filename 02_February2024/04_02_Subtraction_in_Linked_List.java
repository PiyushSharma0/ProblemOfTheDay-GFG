// Link: https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // Convert linked lists to integers
        int num1 = linkedListToNumber(head1);
        int num2 = linkedListToNumber(head2);

        // Subtract the smaller number from the larger one
        int result = Math.max(num1, num2) - Math.min(num1, num2);

        // Convert the result back to a reversed linked list
        return reverseNumberToLinkedList(result);
    }

    private int linkedListToNumber(Node head) {
        int number = 0;
        Node current = head;

        while (current != null) {
            number = number * 10 + current.data;
            current = current.next;
        }

        return number;
    }

    private Node reverseNumberToLinkedList(int number) {
        if (number == 0) {
            return new Node(0);
        }

        Node dummyHead = new Node(0);
        Node current = dummyHead;

        while (number > 0) {
            int digit = number % 10;
            current.next = new Node(digit);
            current = current.next;
            number /= 10;
        }

        return reverseLinkedList(dummyHead.next);
    }

    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
