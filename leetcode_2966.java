// 2966. Divide Array Into Arrays With Max Difference
// optimal approach using sorting to group elements with difference less than k together
// tc - O(nlogn) - sorting
// sc - O(1)

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0;
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i + 1] - nums[i] <= k && nums[i + 2] - nums[i] <= k) {
                int[] temp = new int[] { nums[i], nums[i + 1], nums[i + 2] };
                ans[idx++] = temp;
            } else {
                return new int[0][0];
            }
        }

        return ans;
    }
}
