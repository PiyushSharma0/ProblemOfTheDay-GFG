// Link: https://practice.geeksforgeeks.org/problems/power-set4302/1
// Time Complexity: O(2^n)
// Space Complexity: O(2^n)

class Solution
{
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<>();
        generateSubsequences(s, 0, "", result);
        Collections.sort(result); // Sort the result lexicographically
        return result;
    }

    private void generateSubsequences(String s, int index, String current, List<String> result) {
        if (index == s.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        // Include the current character
        generateSubsequences(s, index + 1, current + s.charAt(index), result);

        // Exclude the current character
        generateSubsequences(s, index + 1, current, result);
    }
}