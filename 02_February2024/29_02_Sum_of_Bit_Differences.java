// Link: https://practice.geeksforgeeks.org/problems/sum-of-bit-differences1153/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long ans = 0;
        
        for(int i = 0; i < 32; i++){
            int count = 0;
            
            for(int j = 0; j < n; j++){
                if((arr[j] & (1 << i)) != 0){
                    count++;
                }
            }
            ans += (long)count * (n-count) * 2;
        }
        
        return ans;
    }
}