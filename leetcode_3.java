// 3. Longest Substring Without Repeating Characters

// brute force - using two forloops for substring and cheking for each substring if it is unique
// tc - O(n^3)
// sc - O(n)

class Solution {
    public boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);

        }

        return s.length() == set.size();
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);

                if (isUnique(sub)) {
                    len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        return maxLen;
    }
}

// optimal - using sliding window and set to check if there is any duplicate element in the current window
// tc - O(n)
// sc - O(n)

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int maxLen = 0;
        int start = 0;
        int end = 0;

        Set<Character> set = new HashSet<>();

        while (end < n) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        
        return maxLen;
    }
}
