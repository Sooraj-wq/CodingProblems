/* An implementation of Kadane's algorithm for the maximum subarray problem. */

public class kadanes {
        public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

/*This is the space optimised version of the algorithm with O(1). The DP approach has space complexity of O(n). */