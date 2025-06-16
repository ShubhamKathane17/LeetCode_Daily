// 1432. Max Difference You Can Get From Changing an Integer
// optimal approach - replacing first non-9 character to 9 to get the biggest possible number
// if the first character is 1 replacing the next non-1 & non-0 character to 0 else replace the first charcter and all its occurances with 1
// tc - O(log10n) every element is visited maximum once in both s & t (number of digits in the given number)
// sc - O(2log10n) 2 strings s & t with length equal to the number of digits in the given number 

class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;

        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }

        pos = 0;
        
        if (t.charAt(0) != '1') {
            t = t.replace(t.charAt(0), '1');
        } 
        else {
            while (pos < t.length() && (t.charAt(pos) == '1' || t.charAt(pos) == '0')) {
                pos++;
            }

            if (pos < t.length()) {
                t = t.replace(t.charAt(pos), '0');
            }
        }
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}
