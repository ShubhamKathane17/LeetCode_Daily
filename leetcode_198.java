// 198. House Robber

// brute force - recursion to check maximum amount the robber can rob
// tc - O()
// sc - O(n) - recursion stack

// class Solution {
//     int sum;

//     public int solve(int[] nums, int idx){
//         if(idx >= nums.length){
//             return 0;
//         }
//         int include = nums[idx] + solve(nums, idx+2);
//         int exclude = solve(nums, idx+1);

//         sum = Math.max(include, exclude);
//         return sum;
//     }
//     public int rob(int[] nums) {
//         sum = 0;
//         solve(nums, 0);

//         return sum;
//     }
// }


// better approach recursion + memoiation
// storing the overlapping subproblem answer in the dp array
// tc - 
// sc - O(n) dp array

// class Solution {
//     public int solve(int[] nums, int idx, int[] dp){
//         if(idx >= nums.length){
//             return 0;
//         }
//         if(dp[idx] != -1){
//             return dp[idx];
//         }
//         int include = nums[idx] + solve(nums, idx+2, dp);
//         int exclude = solve(nums, idx+1, dp);

//         dp[idx] = Math.max(include, exclude);
//         return dp[idx];
//     }
//     public int rob(int[] nums) {
//         int[] dp = new int[nums.length+1];
//         Arrays.fill(dp, -1);
//         return solve(nums, 0, dp);
//     }
// }

// optimal using tabulation storing all the possible outputs for each house number
// tc - O(n)
// sc - O(n)

// class Solution {
//     public int solve(int[] nums) {
//         int n = nums.length;

//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);

//         dp[n-1] = nums[n-1];

//         for (int idx = n-2; idx >= 0; idx--) {
//             int tempAns = 0;

//             if(idx + 2 < n){
//                 tempAns = dp[idx+2];
//             }
//             int include = nums[idx] + tempAns;
//             int exclude = dp[idx + 1];

//             dp[idx] = Math.max(include, exclude);
//         }
//         return dp[0];
//     }

//     public int rob(int[] nums) {
//         return solve(nums);
//     }
// }

// using space optimization
// tc - O(n)
// sc - O(1)
class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        
        int prev = nums[n-1];
        int next = 0;
        int curr = 0;

        for (int idx = n-2; idx >= 0; idx--) {
            int tempAns = 0;

            if(idx + 2 < n){
                tempAns = next;
            }
            int include = nums[idx] + tempAns;
            int exclude = prev;

            curr = Math.max(include, exclude);
            next = prev;
            prev = curr;

        }
        return prev;
    }

    public int rob(int[] nums) {
        return solve(nums);
    }
}


