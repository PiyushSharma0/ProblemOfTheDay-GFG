// Link: https://practice.geeksforgeeks.org/problems/decimal-equivalent-of-binary-linked-list/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    static final int MOD = 1000000007;

    long DecimalValue(Node head) {
        long decimalValue = 0;

        while (head != null) {
            decimalValue = (decimalValue * 2 + head.data) % MOD;
            head = head.next;
        }

        return decimalValue;
    }
}
