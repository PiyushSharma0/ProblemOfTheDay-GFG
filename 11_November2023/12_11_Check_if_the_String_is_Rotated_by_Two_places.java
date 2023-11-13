// Link: https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.
    public static boolean isRotated(String s1, String s2) {
        // Check if s1 is equal to s2 rotated by 2 places clockwise
        if (s1.equals(s2.substring(2) + s2.substring(0, 2))) {
            return true;
        }
        // Check if s1 is equal to s2 rotated by 2 places counterclockwise
        if (s1.equals(s2.substring(s2.length() - 2) + s2.substring(0, s2.length() - 2))) {
            return true;
        }

        return false;
    }
}
