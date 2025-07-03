// 3304. Find the K-th Character in String Game I

// brute force - generating all strings within length k & then returning the kth character
// tc - O(k^2)
// sc - O(k)

class Solution {
    public String generate(String word) {
        String newWord = word;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c = (c == 'z') ? 'a' : (char) (c + 1);

            newWord += String.valueOf(c);
        }

        return newWord;
    }

    public char kthCharacter(int k) {
        String word = "a";

        while (word.length() <= k) {
            word = generate(word);
        }

        return word.charAt(k-1);
    }
}
