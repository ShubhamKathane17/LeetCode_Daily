// 139. Word Break

// brute force - calculating for each substring if it is present in the dictionary and converting the dictionary to set for fast lookup
// tc - O(2^n)
// sc - O(n) - set
class Solution {
    Set<String> set;
    int n;

    public boolean solve(String s, int idx) {
        if (idx >= n) {
            return true;
        }

        for (int end = idx + 1; end <= n; end++) {
            String temp = s.substring(idx, end);
            if (set.contains(temp) && solve(s, end)) {
                return true;
            }
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();

        if (set.contains(s)) {
            return true;
        }

        return solve(s, 0);
    }
}

// better - recursion + memoiation
// tc - O(n2)
// sc - O(n) + O(2^n)

class Solution {
    Set<String> set;
    int n;

    public boolean solve(String s, int idx, Boolean[] dp) {
        if (idx >= n) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int end = idx + 1; end <= n; end++) {
            String temp = s.substring(idx, end);
            if (set.contains(temp) && solve(s, end, dp)) {
                return dp[end] = true;
            }
        }

        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        Boolean[] dp = new Boolean[n + 1];

        if (set.contains(s)) {
            return true;
        }
        return solve(s, 0, dp);
    }
}


// optimal - using tabulation
// tc - O(n2)
// sc - O(n) - dp array
class Solution {
    Set<String> set;
    int n;

    public boolean solve(String s) {
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int start = n-1; start >= 0; start--) {
            for (int end = start + 1; end <= n; end++) {
                String temp = s.substring(start, end);
                if (set.contains(temp) && dp[end]) {
                    dp[start] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();

        if (set.contains(s)) {
            return true;
        }

        return solve(s);
    }
}
