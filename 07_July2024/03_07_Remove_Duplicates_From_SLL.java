// Link: https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1
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
    Node current = head;
    Node previous = head;if(head==null)
    {
        return null;
    }

    if(head.next==null)
    {
        return head;
    }

    while(current!=null&&current.next!=null)
    {
        Node nextt = current.next;

        if (current.data != nextt.data) {
            previous = current;
            current = nextt;

        }

        else {
            int value = current.data;
            if (current == head) {
                while (head != null && head.data == value) {
                    head = head.next;
                }
                previous = head;
                current = head;
            } else {
                while (current != null && current.data == value) {
                    current = current.next;
                }
                previous.next = current;
            }
        }
    }

    return head;
}