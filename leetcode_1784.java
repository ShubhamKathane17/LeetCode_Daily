// optimal - using two pointers to find the first one and the last one if any zero exists between them then the binary string does not have at most one contiguos section of ones
// tc - O(n)
// sc - O(1)

class Solution {
    public boolean checkOnesSegment(String s) {
        int firstOne = -1;
        int lastOne = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && firstOne == -1) {
                firstOne = i;
            }
            if (s.charAt(i) == '1') {
                lastOne = i;
            }
        }

        for (int i = firstOne; i <= lastOne; i++) {
            if (s.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}
