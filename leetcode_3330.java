// 3330. Find the Original Typed String I

// optimal - using two pointers to check for duplicate elements 
// tc - O(n)
// sc - O(1)

class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();

        if(n <= 1){
            return n;
        }

        int start = 0;
        int end = start + 1;

        int count = 1;

        while(end < n){
            while(end < n && word.charAt(start) == word.charAt(end)){
                end++;
                count++;
            }
            if(end < n && word.charAt(start) != word.charAt(end)){
                start = end;
                end = end + 1;
            }
        }
        return count;
    }
}
