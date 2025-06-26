// 62. Unique Paths

// brute force - using recursion to check all the possible ways
// tc - O(2^(m + n))
// sc - O(m + n)

class Solution {
    public int solve(int x, int y, int desx, int desy){
        if(x == desx && y == desy){
            return 1;
        }
        if(x > desx || y > desy){
            return 0;
        }

        int ways = solve(x + 1, y, desx, desy);
        ways += solve(x, y + 1, desx, desy);

        return ways;
    }
    public int uniquePaths(int m, int n) {
        return solve(0, 0, m - 1, n - 1);
    }
}


// better - recursion + memoiation to store the overlapping subproblems
// tc - O(m * n)
// sc - O(m * n) + O(m + n) - dp array + system stack

class Solution {
    public int solve(int x, int y, int desx, int desy, int[][] dp){
        if(x == desx && y == desy){
            return 1;
        }
        if(x > desx || y > desy){
            return 0;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }

        int ways = solve(x + 1, y, desx, desy, dp);
        ways += solve(x, y + 1, desx, desy, dp);

        return dp[x][y] = ways;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return solve(0, 0, m - 1, n - 1, dp);
    }
}

// optimal - using tabulation
// tc - O(m * n)
// sc - pure O(m * n)

class Solution {
    public int solve(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][n - 1] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = 1;
        }

        for (int x = m - 2; x >= 0; x--) {
            for (int y = n - 2; y >= 0; y--) {
                int ways = dp[x + 1][y];
                ways += dp[x][y + 1];

                dp[x][y] = ways;
            }
        }
        return dp[0][0];
    }

    public int uniquePaths(int m, int n) {
        return solve(m, n);
    }
}
