// 53. Maximum Subarray

// brute force - using two forloops to iterate through array to calculte the sum and update it 
// tc - O(n2)
// sc - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}

// optimal - using single loop to calculate the sum  updating it and everytime the sum is negative setting it to 0.
// tc - O(n)
// sc - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;

        while (start < n) {
            sum += nums[start];
            maxSum = Math.max(sum, maxSum);

            if (sum < 0) {
                sum = 0;
            }
            start++;
        }
        return maxSum;
    }
}
