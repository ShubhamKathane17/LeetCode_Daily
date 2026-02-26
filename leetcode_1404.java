// brute force - converting binary string to decimal number and then performing operations on that number fails for long binary string
// tc = O(n) + 0(n)  = converting binary string to integer + performing the operations
// Integer overflows for long string & long too

class Solution {
    public int numSteps(String s) {
        long num = Long.parseLong(s, 2);
        int steps = 0;

        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
                steps++;
            }
            else{
                num += 1;
                steps++;
            }
        }

        return steps;
    }
}

// optimal = performing the operations on the string itself. no extra space needed. extracting the last bit and then adding carry if the effective bit is odd then steps +=2(adding 1 and then diving ) and carry = 1, else steps+=1
// tc = O(n)
// sc = O(1)
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int end = s.length() - 1;
        int carry = 0;

        while (end > 0) {
            int bit = s.charAt(end) - '0';
            int effective = bit + carry;

            if (effective == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
            end--;
        }
        return steps + carry;
    }
}
