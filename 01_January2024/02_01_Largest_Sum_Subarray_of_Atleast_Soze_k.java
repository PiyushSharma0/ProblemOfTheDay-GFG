// Link: https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-atleast-size-k3101/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    
    public long maxSumWithK(long arr[], long n, long k){
        long ans = Long.MIN_VALUE;
        
        long [] maxSum = new long[arr.length];
        long csum = arr[0];
        maxSum[0] = arr[0];
        
        for(int i=1; i<n; i++){
            if(csum>0){
                csum += arr[i];
            }
            else{
                csum  = arr[i];
            }
            
            maxSum[i] = csum;
        }
        
        long atLeastK = 0;
        
        for(int i=0; i<(int)k; i++){
            atLeastK += arr[i];   
        }
        
        ans = Math.max(atLeastK, ans);
        
        for(int i=(int)k; i<arr.length; i++){
            

            atLeastK = atLeastK + arr[i] - arr[i-(int)k];
            ans = Math.max(ans, atLeastK);
            
            long moreThanK = atLeastK + maxSum[i-(int)k];
            ans = Math.max(ans, moreThanK);
        }
        return ans;
    }
}