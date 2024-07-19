// Link: https://practice.geeksforgeeks.org/problems/count-smaller-elements1337/1
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

class Solution {
    int binarySearch(ArrayList<Integer> arr,int key){
        int ind=1;
        int left=0,right=arr.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr.get(mid)==key){
                ind=mid;
                right=mid-1;
            }
            else if(arr.get(mid)>key) right=mid-1;
            else left=mid+1;
        }
        return ind;
    }
    int[] constructLowerArray(int[] arr) {
        ArrayList<Integer> sorted=new ArrayList<>();
        int[] ans=new int[arr.length];
        for(int i:arr) sorted.add(i);
        Collections.sort(sorted);
        for(int i=0;i<arr.length;i++){
            int ind=binarySearch(sorted,arr[i]);
            ans[i]=ind;
            sorted.remove(ind);
        }
        return ans;
    }
}