// Link: https://www.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int len = nums.length;

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[len - i - 1];
            answer = Math.max(answer, Math.max(prefix, suffix));
        }
        return answer;
    }
}