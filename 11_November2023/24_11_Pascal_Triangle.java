// Link: https://www.geeksforgeeks.org/problems/pascal-triangle0652/1
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

import java.util.ArrayList;

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> result = new ArrayList<>();
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            ArrayList<Long> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1L);
                } else {
                    long num = (result.get(j) + result.get(j - 1)) % mod;
                    current.add(num);
                }
            }
            result = current;
        }
        return result;
    }
}
