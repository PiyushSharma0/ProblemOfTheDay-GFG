// Link: https://geeksforgeeks.org/problems/sequence-of-sequence1155/1
// Time Complexity: O(2^N)
// Space Complexity: O(1)

class Solution{
    static int numberSequence(int m, int n) {
        // Base cases
        if (m < n)
            return 0;
        if (n == 0)
            return 1;

        // Recursive calls
        int t = numberSequence(m / 2, n - 1);
        int nt = numberSequence(m - 1, n);

        return t + nt;
    }
}