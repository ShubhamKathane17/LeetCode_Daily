// 2311. Longest Binary Subsequence Less Than or Equal to K

// brute force - recursive solution
// tc - O(2 ^ n);
// sc - O(n) - recursion stack

class Solution {
    int n;
    private int solve(String s, int k, int idx){
        if(idx < 0){
            return 0;
        }

        int bit = s.charAt(idx) - '0';
        int val = bit * (int)Math.pow(2, n - idx - 1);

        int take = 0;
        if(k - val >= 0){
            take = 1 + solve(s, k - val, idx - 1);
        }
        int notTake = solve(s, k, idx - 1);

        return Math.max(take, notTake);
    }
    public int longestSubsequence(String s, int k) {
        n = s.length();
        return solve(s, k, n-1);
    }
}

// recursion + memo - memory limit exceeded - k -> 10^9 not feasible
// tc - O(n * k)
// sc - O(n * k)

class Solution {
    int n;
    private int solve(String s, int k, int idx, int[][] dp){
        if(idx < 0){
            return 0;
        }

        if(dp[idx][k] != -1){
            return dp[idx][k];
        }

        int bit = s.charAt(idx) - '0';
        int val = bit * (int)Math.pow(2, n - idx - 1);

        int take = 0;
        if(k - val >= 0){
            take = 1 + solve(s, k - val, idx - 1, dp);
        }
        int notTake = solve(s, k, idx - 1, dp);

        dp[idx][k] =  Math.max(take, notTake);

        return dp[idx][k];
    }
    public int longestSubsequence(String s, int k) {
        n = s.length();
        if(n <= 2 && k > 3){
            return n;
        }
        int[][] dp = new int[s.length() + 1][k + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return solve(s, k, n-1, dp);
    }
}


// optimal approach - greedily taking the zero bits and checking the value of the one bits 
// tc - O(n)
// sc - O(1)
class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int len = 0;
        int pos = 0;

        for(int i = n-1; i >= 0; i--){
            int bit = s.charAt(i) - '0';
            if( bit == 0){
                len++;
                pos++;
            }else{
                int val = (int)Math.pow(2, pos);
                if(val <= k){
                    len++;
                    pos++;
                    k -= val;
                }
            }
        }

        return len;
        
    }
}
