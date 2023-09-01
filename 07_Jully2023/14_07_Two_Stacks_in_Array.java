// Link: https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class twoStacks {
    int arr[];
    int size;
    int top1, top2;

    twoStacks() {
        size = 100;
        arr = new int[100];
        top1 = -1;
        top2 = size;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Function to remove an element from the top of the stack1.
    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            return -1; // Stack1 is empty
        }
    }

    // Function to remove an element from the top of the stack2.
    int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            return -1; // Stack2 is empty
        }
    }
}
  