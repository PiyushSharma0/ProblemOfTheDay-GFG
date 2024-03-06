// Link: https://practice.geeksforgeeks.org/problems/maximum-index/0
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        leftMin[0] = a[0];
        rightMax[n-1] = a[n-1];
        
        for(int i = 1; i < n; i++){
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], a[i]);
        }
        
        int maxDiff = -1;
        int i = 0, j = 0;
        
        while(i < n && j < n){
            if(leftMin[i] <= rightMax[j]){
                minDiff = Math.max(minDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
