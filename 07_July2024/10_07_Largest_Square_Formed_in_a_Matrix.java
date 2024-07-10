// Link: https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int dp [][] = new int [n+1][m+1];
            int maxi =0;
            for( int i = n-1;i>=0;i--){
                for( int j=m-1;j>=0;j--){
                    int u=dp[i][j+1];
                    int d=dp[i+1][j+1];
                    int r=dp[i+1][j];
                    if(mat[i][j]==1){
                        dp[i][j]=1+Math.min(u,Math.min(d,r));
                        maxi=Math.max(maxi,dp[i][j]);
                    }
                }
            }
            
        return maxi;
    }
}