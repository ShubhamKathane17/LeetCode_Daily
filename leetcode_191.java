// 191. Number of 1 Bits

// brute force - converting int to string and iterating on each character to check if it is '1'
// tc - O(log n)
// sc - O(log n)

class Solution {
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);

        int count = 0;
        for(char c : binaryString.toCharArray()){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }
}


// optimal - using bit manipulation
// tc - O(log n)
// sc - O(1)
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n>>1;
        }
        return count;
    }
}

// optimal - counting only '1' bits
// tc - O(log n) - worst case
// sc - O(1)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n &= (n-1);
        }
        return count;
    }
}
