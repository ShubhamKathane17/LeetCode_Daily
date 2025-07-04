// 3307. Find the K-th Character in String Game II

// brute force - jo bola vo krne ka
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

    public char kthCharacter(long k, int[] operations) {
        String word = "a";

        for (int i : operations) {
            if (i == 0) {
                word += word;
            } else {
                word = generate(word);
            }

            if (word.length() >= k) {
                break;
            }
        }

        return word.charAt((int) k - 1);
    }
}

// optimal - using recursion to breakdown the problem into smaller subproblems
// tc - O(n log k)
// sc - O(log k)

class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k == 1){
            return 'a';
        }

        long len = 1;
        int operation = 0;
        long newK = 0;

        for(int i = 0; i < operations.length; i++){
            len *= 2;
            if(len >= k){
                operation = operations[i];
                newK = k - (len / 2);
                break;
            }
        }

        char ch = kthCharacter(newK, operations);

        if(operation == 0){
            return ch;
        }
        else{
            ch = (ch == 'z') ? 'a' : (char) (ch + 1);
            return ch;
        }
    }
}
