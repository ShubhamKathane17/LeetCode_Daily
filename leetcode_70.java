// 70. Climbing Stairs

// brute force - using recursion to check every possible path
// tc - O(n2)
// sc - O(1) + 0(n) - recursion stack

class Solution {
    public int solve(int n, int stair){
        if(stair == n){
            return 0;
        }
        if(n - stair == 1){
            return 1;
        }
        if(n - stair == 2){
            return 2;
        }

        int takeOne = solve(n, stair + 1);
        int takeTwo = solve(n, stair + 2);

        return takeOne + takeTwo;
    }
    public int climbStairs(int n) {
        int ans = solve(n, 0);
        return ans;
    }
}

// better - recursion + memoiation to store the overlapping subproblems
// tc - O(n)
// sc - O(n) + O(n) - (dp array + recursion stack)

class Solution {
    public int solve(int n, int stair, int[] dp){
        if(stair == n){
            return 0;
        }
        if(n - stair == 1){
            return 1;
        }
        if(n - stair == 2){
            return 2;
        }

        if(dp[stair] != 0){
            return dp[stair];
        }

        int takeOne = solve(n, stair + 1, dp);
        int takeTwo = solve(n, stair + 2, dp);

        dp[stair] = takeOne + takeTwo;
        return dp[stair];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        int ans = solve(n, 0, dp);
        return ans;
    }
}

// optimal - using tabulation to find the answer in one pass
// tc - O(n)
// sc - O(n)
class Solution {
    public int solve(int n, int stair) {
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = 1;
        
        if(n < 2){
            return n;
        }
        dp[n - 2] = 2;

        for (int i = n - 3; i >= 0; i--) {
            int takeOne = dp[i + 1];
            int takeTwo = dp[i + 2];
            dp[i] = takeOne + takeTwo;

        }
        return dp[0];
    }

    public int climbStairs(int n) {
        int ans = solve(n, 0);
        return ans;
    }
}

// space optimization - usign two variables two store the n-1 & n-2 states
// tc - O(n)
// sc - O(1)

class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2 || n == 0){
            return n;
        }

        int zero = 0;
        int one = 1;
        int two = 2;
    
        for (int i = 3; i <= n; i++) {
            int takeOne = one;
            int takeTwo = two;
            one = two;
            two = takeOne + takeTwo;
        }
        return two;
    }
}
