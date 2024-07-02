//Link: https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k) {
        int count = 0;
        long product = 1;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            // Multiply the current element to the product
            product *= a[end];
            
            // Shrink the window by moving the start pointer
            while (product >= k && start <= end) {
                // Divide the product by the element at the start pointer
                product /= a[start];
                start++;
            }
            
            // Count the subarrays ending at the current index
            count += end - start + 1;
        }
        
        return count;
    }
}
