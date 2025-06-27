// 76. Minimum Window Substring

// brute force - checking for each substring
// tc - O(n^3)
// sc - O(n)

class Solution {
    private boolean isMatch(String s, String t){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                continue;
            }
            else{
                map.put(c, map.get(c) - 1);
            }

            if(map.get(c) <= 0){
                map.remove(c);
            }
        }

        return map.size() == 0;
    }
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minWindowSize = Integer.MAX_VALUE;
        String ans = "";

        for(int i = 0; i<n; i++){
            for(int j = i; j < n; j++){
                if(isMatch(s.substring(i, j + 1), t)){
                    if(j - i + 1 < minWindowSize){
                        minWindowSize = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }
}

// optimal - using sliding window and map
// tc - O(n)
// sc - O(n)

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int n = s.length();
        int countRequired = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int minWindowStart = 0;

        while (end < n) {
            char c = s.charAt(end);

            if (map.containsKey(c) && map.get(c) > 0) {
                countRequired--;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);

            while (countRequired == 0) {
                int len = end - start + 1;

                if (len < minWindowSize) {
                    minWindowSize = len;
                    minWindowStart = start;
                }

                char ch = s.charAt(start);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) > 0) {
                    countRequired++;
                }
                start++;
            }
            
            end++;
        }

        if (minWindowSize == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minWindowStart, minWindowStart + minWindowSize);
    }
}
