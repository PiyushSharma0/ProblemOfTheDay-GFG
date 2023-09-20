// Link: https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution{
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        return n > 0 && (n & (n - 1)) == 0;
    }
    
}