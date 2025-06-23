// 190. Reverse Bits

// optimal - isolating the bit and putting it in the leftmost position 

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;

        for(int i = 0; i<32; i++){
            int bit = (n >> i) & 1; // isolating the ith bit
            ans = ans | (bit << (31 - i)); //putting it on its position

        }

        return ans;
        
    }
}
