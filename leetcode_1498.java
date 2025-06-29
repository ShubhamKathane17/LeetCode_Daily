// 1498. Number of Subsequences That Satisfy the Given Sum Condition

// optimal approach - sorting the array and using two pointers to check if the min + max <= target & precomputing the power to reduce the time complexity
// tc - O(n log n)
// sc - O(n) - power array to store the precomputed power of 2

class Solution {
    private int mod = 1000000007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int start = 0;
        int end = n - 1;
        int ans = 0;

        int[] power = new int[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                ans += power[end - start];
                ans %= mod;
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }
}
