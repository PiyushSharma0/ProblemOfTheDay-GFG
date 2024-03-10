// Link: https://practice.geeksforgeeks.org/problems/find-the-nth-character/0
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public char nthCharacter(String s, int r, int n) {
        int len = s.length();

        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }
            s = sb.toString();
        }
        return s.charAt(n);
    }
}