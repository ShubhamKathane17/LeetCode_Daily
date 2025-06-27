// 242. Valid Anagram
// optimal - using freq map of size 26 to store the frequencies of the characters
// tc - O(n)
// sc - O(26)

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }
        
        for(int i : freq){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
