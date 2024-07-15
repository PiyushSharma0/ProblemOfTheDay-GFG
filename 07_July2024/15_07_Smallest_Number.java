// Link: https://practice.geeksforgeeks.org/problems/smallest-number5829/1
// Time Complexity: O(10^d)
// Space Complexity: O(1)

class Solution {
    public static String smallestNumber(int s, int d) {
        int minValue = (int) Math.pow(10, d - 1);
        int maxValue = (int) Math.pow(10, d) - 1;
        for (int i = minValue; i <= maxValue; i++) {
            int number = i;
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            if (sum == s) {
                return Integer.toString(i);
            }
        }
        return "-1";
    }
}