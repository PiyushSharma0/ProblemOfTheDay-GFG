// Link: https://www.geeksforgeeks.org/problems/how-many-xs4514/1
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

class Solution {
    int countX(int L, int R, int X) {
        int count = 0;
        
        for (int i = L + 1; i < R; i++) {
            count += countOccurrences(i, X);
        }
        
        return count;
    }

    // Helper method to count occurrences of digit X in a number
    private int countOccurrences(int number, int X) {
        int count = 0;
        
        while (number > 0) {
            int digit = number % 10;
            if (digit == X) {
                count++;
            }
            number /= 10;
        }
        
        return count;
    }
}
