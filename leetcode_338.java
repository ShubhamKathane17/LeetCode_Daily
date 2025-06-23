// 338. Counting Bits
// optimal - using bit manipulation to count the number of bits in every number from 0 - n
// tc- O(n log n) - log n in worst case to count the number of bits in the number & n to iterate on 0 - n
// sc - O(1)


class Solution {
    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n &= (n-1);
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = hammingWeight(i);
        }

        return ans;
    }
}
