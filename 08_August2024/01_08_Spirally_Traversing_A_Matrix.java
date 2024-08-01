// Link: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
// Time Complexity: O(N*M)
// Space Complexity: O(N*M)

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        
        int i=0,j=-1,d=0,count=0;
        int n=matrix.length,m=matrix[0].length;
        ArrayList<Integer> ans=new ArrayList<>();
        int flag[][]=new int[n][m];
        while(true){
        
            if(count==n*m) break;
          if(d==0){
              if(j+1>=m || flag[i][j+1]==1){
                  d=1;
                  count--;
              }
              else{ 
                  j++;
                  flag[i][j]=1;
                  ans.add(matrix[i][j]);
                  
              }
          }
          else if(d==1){
               if(i+1>=n || flag[i+1][j]==1){
                  d=2;
                  count--;
              }
              else {
                  i++;
                  flag[i][j]=1;
                  ans.add(matrix[i][j]);
                  
              }
          }
           else if(d==2){
               if(j-1<0 || flag[i][j-1]==1){
                  d=3;
                  count--;
              }
              else{ 
                  j--;
                  flag[i][j]=1;
                  ans.add(matrix[i][j]);
                  
              }
          }
           else if(d==3){
               if(i-1<0 || flag[i-1][j]==1){
                  d=0;
                  count--;
              }
              else {
                  i--;
                  flag[i][j]=1;
                  
                  ans.add(matrix[i][j]);
                  
              }
          }
          count++;
        }
        return ans;
    }
}
