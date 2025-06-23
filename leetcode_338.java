// 338. Counting Bits
// brute force - using bit manipulation to count the number of bits in every number from 0 - n
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

// optimal - using bit manipulation directly for each number & storing directly instead of calling another function using observation
// tc - O(n)
// sc - O(1)


class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }

        return ans;
    }
}
