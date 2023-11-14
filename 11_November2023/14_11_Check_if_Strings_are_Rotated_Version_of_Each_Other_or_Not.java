// Link: https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution
{
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2)
    {
        // Check if the lengths of both strings are equal and not zero.
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        // Concatenate s1 with itself.
        String concatenatedString = s1 + s1;

        // Check if s2 is a substring of the concatenated string.
        return concatenatedString.contains(s2);
    }
}
