// Link: https://practice.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1
// Time Complexity: O(N1 + N2 + N3)
// Space Complexity: O(1)


public static int maxEqualSum(int N1, int N2, int N3, int[] S1, int[] S2, int[] S3) {
    int sum1 = calculateSum(S1, N1);
    int sum2 = calculateSum(S2, N2);
    int sum3 = calculateSum(S3, N3);
    
    int top1 = 0, top2 = 0, top3 = 0;
    
    while (true) {
        // Check if the current sums are equal
        if (sum1 == sum2 && sum2 == sum3) {
            return sum1;
        }
        
        // Find the stack with the maximum sum
        int maxSum = Math.max(sum1, Math.max(sum2, sum3));
        
        // Subtract the top element from the stack with the maximum sum
        if (maxSum == sum1) {
            sum1 -= S1[top1++];
        } else if (maxSum == sum2) {
            sum2 -= S2[top2++];
        } else if (maxSum == sum3) {
            sum3 -= S3[top3++];
        } else {
            break;  // No common maximum sum found
        }
    }
    
    return 0;
}

private static int calculateSum(int[] stack, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += stack[i];
    }
    return sum;
}
