// lintcode 659 - encode and decode string

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */

    public List<String> decode(String str) {
        // write your code here
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;
            
            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            ans.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return ans;
    }
}
