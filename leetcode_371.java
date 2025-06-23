// 371. Sum of Two Integers

// brute force - using '+' operator
// tc = constant
// sc - contant

class Solution {
    public int getSum(int a, int b) {
        return a + b;
    }
}

// using bit manipulation
// tc - constant
// sc - constant

class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = ((a & b) << 1);
            a = (a ^ b);
            b = temp;
        }
        return  a;
    }
}
