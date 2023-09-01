// Link: https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> generateNextPalindrome(int num[], int n) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(num[i]); // Copy num array for output
        }

        int i = 0, j = n - 1;

        while (i < j) { // Convert 'out' array into a palindrome
            out.set(j, out.get(i));
            i++;
            j--;
        }

        boolean isBig = false;
        for (int it = n / 2; it < n; ++it) { // Check if 'out' is greater than 'num'
            if (out.get(it) > num[it]) {
                isBig = true;
                break;
            }
            if (out.get(it) < num[it])
                break;
        }

        if (isBig) // If 'out' is greater, no further operation needed
            return out;

        i = (n % 2 == 1) ? n / 2 : (n / 2 - 1);  // Mids of the out array
        j = n / 2;

        while (i >= 0) { // Incrementing numbers from the middle to the corners
            if (out.get(i) < 9) {
                out.set(i, out.get(i) + 1);
                out.set(j, out.get(i));
                return out;
            }
            out.set(i, 0);
            out.set(j, 0);
            i--;
            j++;
        }

        out.set(0, 1); // If all digits are 9, convert to [1, 0, 0, ..., 0, 1]
        out.add(1);

        return out;
    }
}
