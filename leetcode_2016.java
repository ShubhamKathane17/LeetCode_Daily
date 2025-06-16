// 2016. Maximum Difference Between Increasing Elements
// brute force - using 2 for loops to calculate difference between each and every element
// tc - O(n^2)
// sc - O(1)

class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                maxDiff = Math.max(diff, maxDiff);
            }
        }
        if (maxDiff <= 0) {
            return -1;
        }
        return maxDiff;
    }
}


// optimal solution - using single for loop and keeping track of smallest element & calculting difference with each element which is greater than the bottom
// tc = O(n)
// sc = O(1)

class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int n = nums.length;
        int bottom = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > bottom) {
                maxDiff = Math.max(maxDiff, nums[i] - bottom);
            } 
            bottom = Math.min(bottom, nums[i]);
        }

        return maxDiff;
    }
}
