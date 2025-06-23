// 153. Find Minimum in Rotated Sorted Array

// brute force - usign linear search to calculate the minimum element in the array
// tc - O(n)
// sc - O(1)

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }
}

// optimal - using modified binary search to find the minimum elemnet in the roatated and sorted array
// tc - O(log n)
// sc - O(1)

class Solution {
    public int bs(int[] nums, int start, int end) {
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) {
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }

        return ans;
    }

    public int findMin(int[] nums) {
        return bs(nums, 0, nums.length - 1);
    }
}
