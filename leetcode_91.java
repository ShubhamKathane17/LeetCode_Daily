// 91. Decode Ways

// brute force - using recursion 
// tc - O(2^n)
// sc - O(n)

class Solution {
    int n;
    public int solve(String s, int idx){
        if(idx >= n){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }

        int ways = solve(s, idx + 1);

        if(idx + 2 <= n && Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
            ways += solve(s, idx + 2);

        return ways;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        n = s.length();
        return solve(s, 0);
    }
}

// better - using memoiation with recursion
// tc - O(n)
// sc - O(n) + O(n) - dp array + recursion stack

class Solution {
    int n;
    public int solve(String s, int idx, int[] dp){
        if(idx >= n){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }

        if(dp[idx] != 0){
            return dp[idx];
        }

        int ways = solve(s, idx + 1, dp);

        if(idx + 2 <= n && Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
            ways += solve(s, idx + 2, dp);

        return dp[idx] = ways;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        n = s.length();
        int[] dp = new int[s.length() + 1];
        return solve(s, 0, dp);
    }
}

// optimal 1 - using tabulation 
// tc - O(n)
// sc - pure O(n) - dp array

class Solution {
    int n;
    
    public int solve(String s) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[0] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {

            if(s.charAt(idx) == '0'){
                dp[idx] = 0;
                continue;
            }

            int ways = dp[idx + 1];

            if (idx + 1 < n && Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
                ways += dp[idx + 2];

            dp[idx] = ways;
        }

        return dp[0];
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        n = s.length();
        return solve(s);
    }
}

// super optimal - using space optimization
// tc - O(n)
// sc - O(1)

class Solution {
    int n;

    public int solve(String s) {
        int next1 = 1;
        int next2 = 0;

        for (int idx = n - 1; idx >= 0; idx--) {

            if (s.charAt(idx) == '0') {
                int curr = 0;
                next2 = next1;
                next1 = curr;
                continue;
            }

            int curr = next1;

            if (idx + 1 < n && Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
                curr += next2;

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        n = s.length();
        return solve(s);
    }
}
