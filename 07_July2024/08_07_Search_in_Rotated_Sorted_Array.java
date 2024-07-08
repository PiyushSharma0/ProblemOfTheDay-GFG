// Link: https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
// Time Complexity: O(logn)
// Space Complexity: O(1)

class Solution {
    int search(int[] arr, int key) {
        int low =0;
        int high = arr.length-1;
        int mid ;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid]< arr[0]){
                if(key<=arr[high] && key>arr[mid]) low = mid+1;
                else high = mid-1;
            }
            else{
                if(key>= arr[low] && key<arr[mid]) high = mid-1;
                else low = mid+1;
                
            }
        }
        return -1;
    }
}