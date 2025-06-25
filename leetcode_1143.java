// 1143. Longest Common Subsequence

// brute force - using recursion to calculate the longest common subsequence using take/skip method and then returning the maximum
// tc - O(2 ^ (text1.length + text2.length))
// sc - O(text1.length + text2.length)  - recursion stack space

class Solution {
    public int solve(String text1, String text2, int idx1, int idx2){
        if(idx1 >= text1.length() || idx2 >= text2.length()){
            return 0;
        }

        if(text1.charAt(idx1) == text2.charAt(idx2)){
            return 1 + solve(text1, text2, idx1 + 1, idx2 + 1);
        }
        int case1 = solve(text1, text2, idx1 + 1, idx2);
        int case2 = solve(text1, text2, idx1, idx2 + 1);

        return Math.max(case1, case2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0);
    }
}

// better - using recursion + memoiation to store the overlapping subproblems
// tc - O(m * n)
// sc - O(m * n) + O(m + n) - dp array  + recursion stack space 

class Solution {
    public int solve(String text1, String text2, int idx1, int idx2, int[][] dp){
        if(idx1 >= text1.length() || idx2 >= text2.length()){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int case1 = 0;

        if(text1.charAt(idx1) == text2.charAt(idx2)){
            case1 = 1 + solve(text1, text2, idx1 + 1, idx2 + 1, dp);
        }
        int case2 = solve(text1, text2, idx1 + 1, idx2, dp);
        int case3 = solve(text1, text2, idx1, idx2 + 1, dp);

        dp[idx1][idx2] =  Math.max(case1, Math.max(case2, case3));
        return dp[idx1][idx2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return solve(text1, text2, 0, 0, dp);
    }
}

// optimal - using tabulation or bottom up 
// tc - O(m * n);
// sc - O(m * n)

class Solution {
    public int solve(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int idx1 = 1; idx1 <= text1.length(); idx1++) {
            for (int idx2 = 1; idx2 <= text2.length(); idx2++) {
                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                } else {
                    int case2 = dp[idx1 - 1][idx2];
                    int case3 = dp[idx1][idx2 - 1];
                    int maxi = Math.max(case2, case3);
                    dp[idx1][idx2] = maxi;
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2);
    }
}
