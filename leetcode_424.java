// 424. Longest Repeating Character Replacement

// brute force - calculating for every substring
// tc - O(n^2)
// sc - O(26)

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int maxFreq = 0;
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq[c - 'A']++;
                maxFreq = Math.max(maxFreq, freq[c - 'A']);

                int operations = (j - i + 1) - maxFreq;

                if (operations <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}

// optimal - using two pointers + sliding window
// tc - O(n)
// sc - O(26)

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        int start = 0;
        int end = 0;

        while (end < n) {
            char c = s.charAt(end);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            int operations = (end - start + 1) - maxFreq;

            if (operations <= k) {
                maxLen = Math.max(maxLen, end - start + 1);
            } else {
                char ch = s.charAt(start);
                freq[ch - 'A']--;
                start++;
            }

            end++;

        }
        return maxLen;
    }
}
