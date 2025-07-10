// 1751. Maximum Number of Events That Can Be Attended II

// brute force - recursion and linear search
// tc - O(2^n * n)
// sc - O(k * n) - recursion stack

class Solution {
    int n;
    public int solve(int[][] events, int k, int currIdx) {
        if (k == 0 || currIdx >= n) {
            return 0;
        }

        int skip = 0 + solve(events, k, currIdx + 1);
        int i;

        for (i = currIdx + 1; i < n; i++) {
            if (events[i][0] > events[currIdx][1]) {
                break;
            }
        }
        int take = events[currIdx][2] + solve(events, k - 1, i);

        return Math.max(take, skip);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        n = events.length;

        return solve(events, k, 0);
    }
}

// better - using recursion + memo & linear search
// tc - O(k * n * n)
// sc - O(k * n) - dp

class Solution {
    int n;
    public int solve(int[][] events, int k, int currIdx, int[][] dp) {
        if (k == 0 || currIdx >= n) {
            return 0;
        }

        if(dp[currIdx][k] != 0){
            return dp[currIdx][k];
        }

        int skip = 0 + solve(events, k, currIdx + 1, dp);
        int i;

        for (i = currIdx + 1; i < n; i++) {
            if (events[i][0] > events[currIdx][1]) {
                break;
            }
        }
        int take = events[currIdx][2] + solve(events, k - 1, i, dp);

        dp[currIdx][k] = Math.max(take, skip);

        return dp[currIdx][k];
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        n = events.length;

        int[][] dp = new int[n + 1][k + 1];

        return solve(events, k, 0, dp);
    }
}

// better - using recursion + memo & binary search to find the element just greater than the current ele
// tc - O(k * n * log n)
// sc - O(k * n)

class Solution {
    int n;

    public int bs(int[][] events, int start, int end, int currIdx) {
        int idx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (events[mid][0] > events[currIdx][1]) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    public int solve(int[][] events, int k, int currIdx, int[][] dp) {
        if (currIdx < 0 || k == 0 || currIdx >= n) {
            return 0;
        }

        if (dp[currIdx][k] != 0) {
            return dp[currIdx][k];
        }

        int skip = 0 + solve(events, k, currIdx + 1, dp);

        int start = currIdx + 1;
        int end = n - 1;
        int idx = bs(events, start, end, currIdx);

        int take = events[currIdx][2] + solve(events, k - 1, idx, dp);

        dp[currIdx][k] = Math.max(take, skip);
        return dp[currIdx][k];
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        n = events.length;

        int[][] dp = new int[n + 1][k + 1];

        return solve(events, k, 0, dp);
    }
}
