// Link: https://practice.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-8/0
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution{
    int DivisibleByEight(String s){
        return Integer.parseInt(s.substring(Math.max(s.length() - 3, 0))) % 8 == 0 ? 1 : -1;
    }
}