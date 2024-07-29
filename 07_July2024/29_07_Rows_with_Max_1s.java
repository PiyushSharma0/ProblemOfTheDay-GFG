// Link: https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
// Time Complexity: O(n*m)
// Space Complexity: O(1)

class Solution {
    public int rowWithMax1s(int arr[][]) {
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j][i]==1)return j;
            }
        }
        return -1;
    }
}