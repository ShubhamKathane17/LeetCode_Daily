// counting the number of swaps needed for alternate binary string "1010..." and "0101...." and returning minimum among them
// tc - O(n)
// sc - O(1)
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int count1 = 0;
        int count2 = 0;
        int ptr1 = 0;
        int ptr2 = 1;

        while(ptr1 < n || ptr2 < n){
            if(ptr1 < n && s.charAt(ptr1) == '1'){
                count1++;
            }
            if(ptr2 < n && s.charAt(ptr2) == '0'){
                count1++;
            }
            ptr1 += 2;
            ptr2 += 2;
        }

        ptr1 = 0;
        ptr2 = 1;

        while(ptr1 < n || ptr2 < n){
            if(ptr1 < n && s.charAt(ptr1) == '0'){
                count2++;
            }
            if(ptr2 < n && s.charAt(ptr2) == '1'){
                count2++;
            }
            ptr1 += 2;
            ptr2 += 2;
        }


        return Math.min(count1, count2);
    }
}

// counting the number of swaps needed for alternate binary string "1010..." and "0101...." and returning minimum among them cleaner code
// tc - O(n)
// sc - O(1)
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < n ; i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1'){
                    count1++;
                }
                if(s.charAt(i) == '0'){
                    count2++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    count1++;
                }
                if(s.charAt(i) == '1'){
                    count2++;
                }
            }
        }


        return Math.min(count1, count2);
    }
}

// better - calculating the swaps to create "1010..." string and comparing it with "0101.." string by subtracting the number of swaps count1 from length
// tc - O(n)
// sc - O(1)


class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int count1 = 0;
  
        for(int i = 0; i < n ; i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1'){
                    count1++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    count1++;
                }
            }
        }


        return Math.min(count1, n - count1);
    }
}
