// 5. Longest Palindromic Substring

// brute force - using 3 loops to check if the substring is palindrome
// tc - O(n^3)
// sc - O(n) - to store the substring

class Solution {
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String sub = s.substring(i, j+1);
                if(isPalindrome(sub)){
                    if(sub.length() > maxLen){
                        maxLen = sub.length();
                        ans = sub;
                    }
                }   
            }
        }
        return ans;
    }
}

// brute force - using recursion
// tc - O(n^3)
// tc - O(n)

class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return isPalindrome(s, start + 1, end - 1);
        }

        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

// better - recursion + memo
// tc - O(n^2)
// sc - O(n^2)
class Solution {
    public int isPalindrome(String s, int start, int end, int[][] dp) {
        if (start >= end) {
            return 1;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = isPalindrome(s, start + 1, end - 1, dp);
        }

        return dp[start][end] = 0;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int maxLen = 0;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, dp) > 0) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
