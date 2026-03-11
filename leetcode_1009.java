// brute force - converting number to binary stringbuilder and then replacing the occurance of each digit with its complement
// tc - O(n)
// sc - O(log n) - binary stringbuilder length = number of digits

class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1'){
                sb.setCharAt(i, '0');
            }
            else{
                sb.setCharAt(i, '1');
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}


// optimal - calculating the digits and then calculating the sum of the number and its complement which is "1111..11" which is equal to 2^digits - 1 and then xoring the original number with the sum we get the complement
// tc - O(logn)
// sc - O(1)
class Solution {
    public int bitwiseComplement(int n) {
        double count = 0;
        int a = n;

        while(a != 0){
            count++;
            a = a >> 1;
        }
        
        int sum = (int)Math.pow(2, count);
        int ans = (sum - 1) ^ n;

        if(n == 0)
            return 1;
        
        return ans;
    }
}
