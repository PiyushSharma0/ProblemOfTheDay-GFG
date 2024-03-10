// Link: https://practice.geeksforgeeks.org/problems/remove-duplicates/0
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    String removeDuplicates(String str) {
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : uniqueChars) {
            result.append(ch);
        }

        return result.toString();
    }
}