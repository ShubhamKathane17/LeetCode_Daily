// leetcode_1432

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
