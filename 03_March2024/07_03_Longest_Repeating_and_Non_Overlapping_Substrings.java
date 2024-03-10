// Link: https://practice.geeksforgeeks.org/problems/longest-repeating-and-non-overlapping-substring/0
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    static String longestSubstring(String s, int n) {
        String resultedString = "";
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = i; j < n; j++) {
                temp = temp + str.charAt(j);
                if (str.indexOf(temp, j + 1) != -1) {
                    if (resultedString.length() < temp.length())
                        resultedString = temp;
                } else
                    break;
            }
        }
        return resultedString == "" ? "-1" : resultedString;
    }
}