// 322. Coin Change

// brute force - using recursion to calculate each and every possibility to check the minimum coins required
// tc - O(n^amount)
// sc - O(amount) - recursion stack

class Solution {
    public int solve(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];

            if(amount - coin >= 0){
                int recAns = solve(coins, amount - coin);
                if(recAns != Integer.MAX_VALUE){
                    ans = 1 + recAns;
                }
            }

            mini = Math.min(mini, ans);
        }
        return mini;
    }
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount);

        if(ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }
}

// better - recursion + memoiation - using dp array to store the overlapping subproblems
// tc - O(amount * n)
// sc - O(amount) - dp array + recursion stack

class Solution {
    public int solve(int[] coins, int amount, int[] dp){
        if(amount == 0){
            return 0;
        }

        int mini = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        if(dp[amount] != 0){
            return dp[amount];
        }

        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];

            if(amount - coin >= 0){
                int recAns = solve(coins, amount - coin, dp);
                if(recAns != Integer.MAX_VALUE){
                    ans = 1 + recAns;
                }
            }
            mini = Math.min(mini, ans);
        }
        dp[amount] = mini;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int ans = solve(coins, amount, dp);

        if(ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }
}


// optimal - using tabulation
// tc - O(n * amount)
// sc - O(amount)

class Solution {
    public int solve(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int val = 1; val <= amount; val++) {
            int mini = Integer.MAX_VALUE;
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                if (val - coin >= 0) {
                    int recAns = dp[val - coin];
                    if (recAns != Integer.MAX_VALUE) {
                        ans = 1 + recAns;
                    }
                }
                mini = Math.min(mini, ans);
            }

            dp[val] = mini;
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount);

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }
}
