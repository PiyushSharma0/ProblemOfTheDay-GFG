// Link: https://practice.geeksforgeeks.org/problems/edit-distance3702/1
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int a=str1.length();
        int b=str2.length();
        int ac[][]=new int[a+1][b+1];
        for(int i=0;i<=a;i++) ac[i][0]=i;
        
        for(int j=0;j<=b;j++) ac[0][j]=j;
        
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    ac[i][j]=ac[i-1][j-1];
                }else{
                    ac[i][j]=1+Math.min(Math.min(ac[i][j-1],ac[i-1][j]),ac[i-1][j-1]);
                }
            }
        }
        return ac[a][b];
        
    }
}