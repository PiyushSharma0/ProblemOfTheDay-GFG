// Link: https://practice.geeksforgeeks.org/problems/strings-count-java/1/
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution { 
    static long countStr(long n){
        return 1 + 2 * n + (n * (n - 1)) + ((n * (n - 1)) / 2) + (n * (n - 1) * (n - 2)) / 2;
	}
}