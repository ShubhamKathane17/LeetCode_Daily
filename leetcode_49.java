// 49. Group Anagrams

// brute force - sorting each string in str and mapping 
// tc - O(n * k log k) - n for iterating on the strs array & k log k - sorting each string 
// sc - O(n) - map

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        ans.addAll(map.values());
        return ans;
    }
}

// optimal - using freq array to store the frequencies of the lowercase characters 
// tc - O(n * k)
// sc - O(26) + O(k)

class Solution {
    public String generateKey(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < freq[i]; j++)
                    key.append((char) (i + 'a'));
            }
        }

        return key.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = generateKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
