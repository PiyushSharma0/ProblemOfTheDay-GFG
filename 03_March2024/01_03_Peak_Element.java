// Link: https://practice.geeksforgeeks.org/problems/maximum-odd-binary-number3446/1
// Time Complexity: O(logn)
// Space Complexity: O(1)

class Solution
{
	public int peakElement(int[] arr,int n)
    {
       if( n == 1) 
          return 0;
       if(arr[0] > arr[1]) 
          return 0;
        if(arr[n-1] > arr[n-2]) 
        return n-1;
        
      int   low = 1;
      int high = n-2;
      
      while(low<=high){
           int mid = (low+high)/2;
           
           if(arr[mid]>arr[mid-1] && arr[mid]>=arr[mid+1]){
                return mid;
           }
           else if (arr[mid-1] < arr[mid]){
                low = mid+1;
           }
          else if (arr[mid+1] <= arr[mid]){
               high = mid-1;
          }
          else{
               low = mid+1;
          }
      }
    
        return 0;
    }
}