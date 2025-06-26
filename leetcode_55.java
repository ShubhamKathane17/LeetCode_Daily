// 55. Jump Game

// brute force - using recursion to calculate for each index that we can jump
// tc - O(2 ^ n)
// sc - O(n)

class Solution {
    private int n;

    private boolean solve(int[] nums, int idx) {
        if (idx >= n - 1) {
            return true;
        }
        if (nums[idx] == 0) {
            return false;
        }

        int jumps = nums[idx];
        boolean ans = false;

        for (int i = 1; i <= jumps; i++) {
            ans |= solve(nums, idx + i);
        }

        return ans;
    }

    public boolean canJump(int[] nums) {
        n = nums.length;
        if (n <= 1) {
            return true;
        }

        return solve(nums, 0);
    }
}

// better - using recursion + memoiation to store the overlapping subproblems
// tc - O(n)
// sc - O(n) + O(n) dp array + recursion stack

class Solution {
    private int n;

    private boolean solve(int[] nums, int idx, Boolean[] dp) {
        if (idx >= n - 1) {
            return true;
        }
        if (nums[idx] == 0) {
            return false;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        int jumps = nums[idx];
        boolean ans = false;

        for (int i = 1; i <= jumps; i++) {
            ans |= solve(nums, idx + i, dp);
        }

        return dp[idx] = ans;
    }

    public boolean canJump(int[] nums) {
        n = nums.length;
        if (n <= 1) {
            return true;
        }

        Boolean[] dp = new Boolean[n];

        return solve(nums, 0, dp);
    }
}

// better - using tabulation 
// tc - O(n)
// sc - pure O(n)

class Solution {
    private int n;

    private boolean solve(int[] nums) {
        Boolean[] dp = new Boolean[n];

        dp[n - 1] = true;

        for (int idx = n - 2; idx >= 0; idx--) {
            int jumps = nums[idx];
            boolean ans = false;
            for (int i = 1; i <= jumps; i++) {
                if (idx + i >= n) {
                    ans = true;
                    break;
                } else {
                    ans |= dp[idx + i];
                    if (ans)
                        break;
                }
            }
            dp[idx] = ans;
        }

        return dp[0];
    }

    public boolean canJump(int[] nums) {
        n = nums.length;
        if (n <= 1) {
            return true;
        }
        return solve(nums);
    }
}

// optimal - calculating greedily that we can reach the final position
// tc - O(n)
// sc - O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        int maxReachable = 0;

        for(int i = 0; i < n; i++){
            if(i > maxReachable){
                return false;
            }
            if(maxReachable >= n - 1){
                return true;
            }

            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        return true;
    }
}
