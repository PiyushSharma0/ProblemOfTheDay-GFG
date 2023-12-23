// Link: https://practice.geeksforgeeks.org/problems/count-element-occurences/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.*;

class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int cnt = 0;
        for(int count: map.values()) {
            if(count > n/k) cnt++;
        }
        return cnt;
    }
}