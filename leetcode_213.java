// 213. House Robber II

// brute force - checking every possible route using recursion
// tc - O(2^n)
// sc - O(n) - recursion stack

class Solution {
    private int n;
    private int solve(int[] nums, int start, int end){
        if(start >= end){
            return 0;
        }

        int take = nums[start] + solve(nums, start + 2, end);
        int notTake = solve(nums, start + 1, end);

        return Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(solve(nums, 0, n-1), solve(nums, 1, n));
    }
}

// better - using recursion + memoiation to store the overlapping subprblems
// tc - O(n)
// sc - O(n) - using dp array + O(n) - recursion stack

class Solution {
    private int n;
    private int solve(int[] nums, int start, int end, int[] dp){
        if(start >= end){
            return 0;
        }

        if(dp[start] != -1){
            return dp[start];
        }

        int take = nums[start] + solve(nums, start + 2, end, dp);
        int notTake = solve(nums, start + 1, end, dp);

        dp[start] = Math.max(take, notTake);
        return dp[start];
    }

    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        int case1 = solve(nums, 0, n-1, dp);

        Arrays.fill(dp, -1);
        int case2 = solve(nums, 1, n, dp);

        return Math.max(case1, case2);
    }
}

// optimal - using tabulation
// tc - O(n)
// sc - pure O(n) 

class Solution {
    private int n;
    private int solve(int[] nums){
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1 ; i <= n - 1; i++){
            int skip = dp[i - 1];
            int take = nums[i - 1] + (i-2 >= 0 ? dp[i - 2] : 0);
            dp[i] = Math.max(skip, take);
        }

        int ans1 = dp[n-1];
        // Arrays.fill(dp, 0);

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2 ; i <= n; i++){
            int skip = dp[i - 1];
            int take = nums[i - 1] + (i-2 >= 0 ? dp[i - 2] : 0);
            dp[i] = Math.max(skip, take);
        }

        int ans2 = dp[n];

        return Math.max(ans1, ans2);
    }

    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return solve(nums);
    }
}

// optimal 2 - space optimizing the dp array
// tc - O(n)
// sc - O(1)

class Solution {
    private int n;
    private int solve(int[] nums, int start, int end){
        int prev1 = 0;
        int prev2 = 0;

        for(int i = start ; i <= end; i++){
            int skip = prev1;
            int take = nums[i] + prev2;
            int curr = Math.max(skip, take);

            prev2 = prev1;
            prev1 = curr;
        }

        int ans1 = prev1;
        return ans1;
    }

    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int case1 = solve(nums, 0, n-2);
        int case2 = solve(nums, 1, n-1);

        return Math.max(case1, case2);
    }
}
