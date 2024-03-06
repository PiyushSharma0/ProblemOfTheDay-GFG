// Link: https://practice.geeksforgeeks.org/problems/swap-the-array-elements/0
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution
{
    public void swapElements(int[] arr, int n)
    {
        for(int i = 0; i < n - 2; i++){
            swap(arr, i, i+2);
        }
    }
    
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}