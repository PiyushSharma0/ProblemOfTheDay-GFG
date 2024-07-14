// Link: https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s/0
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    void segregate0and1(int[] arr) {
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[cnt];
                arr[cnt]=temp;
           cnt++;
            }
        }
    }
} 