// 647. Palindromic Substrings

// brute force - using 3 forloops to check if each substring is palindrome and checking if the lenght is maximum
// tc - O(n^3)
// sc - O(1)

class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(s, i, j)){
                    ans++;
                }
            }
        }

        return ans;
    }
}

// brute force - recursive solution
// tc - O(n^3)
// sc - O(n) - recursion stack

class Solution {
    public boolean isPalindrome(String s, int start, int end){
        if(start >= end){
            return true;
        }

        if(s.charAt(start) != s.charAt(end)){
            return false;
        }

        return isPalindrome(s, start + 1, end - 1);
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(s, i, j)){
                    ans++;
                }
            }
        }

        return ans;
    }
}

// slightly better - reucrsion + memoiation
// tc - O(n^2)
// sc - O(n^2)

class Solution {
    int[][] dp;

    public int isPalindrome(String s, int start, int end){
        if(start >= end){
            return 1;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        if(s.charAt(start) != s.charAt(end)){
            return dp[start][end] = 0;
        }

        return dp[start][end] = isPalindrome(s, start + 1, end - 1);
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        dp = new int[1001][1001];

        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(s, i, j) > 0){
                    ans++;
                }
            }
        }

        return ans;
    }
}

// better - using tabulation
// tc - O(n ^ 2)
// sc - O(n ^ 2)

class Solution {
    boolean[][] dp;

    public int isPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        int count = 0;

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i+L-1 < n; i++) {
                int j = i + L - 1;

                if(i == j){
                    dp[i][i] = true;
                }
                else if(i + 1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);
                }

                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        return isPalindrome(s);
    }
}

// optimal - using properties of palindromes
// tc - O(n ^ 2)
// sc - O(1)

class Solution {
    int count;

    public void isPalindrome(int left, int right, String s, int n) {
        
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }

    public int countSubstrings(String s) {
        int n = s.length();
        count = 0;

        for(int i = 0; i<n; i++){
            isPalindrome(i, i, s, n);
            isPalindrome(i, i+1, s, n);
        }

        return count;
    }
}
