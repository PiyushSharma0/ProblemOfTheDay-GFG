// Link: https://practice.geeksforgeeks.org/problems/remaining-string1616/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public String printString(String s, char ch, int count) {
        int ct=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==ch)
            ct++;
            if(ct==count && (i+1)!=(s.length())) return s.substring(i+1,s.length());
        }
        return new String("");
    }
}