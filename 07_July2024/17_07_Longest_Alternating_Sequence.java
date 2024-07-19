// Link: https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int alternatingMaxLength(int[] a) {
        int n=a.length;
        if(n==1) return 1;
        if(n==2){
            if(a[0]==a[1]) return 1;
            else return 2;
        }
        int ans=1;
        int pre=a[0];
        for(int i=1;i<n-1;i++){
            if((pre<a[i] && a[i]>a[i+1]) || (pre>a[i] && a[i]<a[i+1])){
                ans++;
                pre=a[i];
            }
        }
        return ans+1;
        
    }
}