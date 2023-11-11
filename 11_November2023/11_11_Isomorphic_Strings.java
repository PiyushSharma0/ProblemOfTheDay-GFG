// Link: https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

class Solution
{
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2)
    {
        // If the lengths of the two strings are not equal, they can't be isomorphic.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create two maps to store the mapping of characters from str1 to str2 and vice versa.
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        // Iterate through each character in both strings.
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // If the character from str1 is already mapped, check if it matches the corresponding character in str2.
            if (map1.containsKey(char1)) {
                if (map1.get(char1) != char2) {
                    return false; // If not, the strings are not isomorphic.
                }
            } else {
                // If the character from str1 is not mapped, map it to the corresponding character in str2.
                map1.put(char1, char2);
            }

            // Similarly, check for mapping from str2 to str1.
            if (map2.containsKey(char2)) {
                if (map2.get(char2) != char1) {
                    return false; // If not, the strings are not isomorphic.
                }
            } else {
                // If the character from str2 is not mapped, map it to the corresponding character in str1.
                map2.put(char2, char1);
            }
        }

        return true; // If no inconsistencies are found, the strings are isomorphic.
    }
}
