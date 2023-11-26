// Link: https://practice.geeksforgeeks.org/problems/print-pattern/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {

    // The main function that generates the pattern
    public List<Integer> pattern(int N) {
        List<Integer> out = new ArrayList<>();
        solve(N, out);
        return out;
    }

    // Recursive function to generate the pattern
    private void solve(int n, List<Integer> out) {
        out.add(n); // Add the current value to the list
        if (n <= 0) {
            return; // If the value is less than or equal to 0, stop the recursion
        }
        solve(n - 5, out); // Recursively call the function with N - 5
        out.add(n); // Add the current value again after the recursive call
    }
}
