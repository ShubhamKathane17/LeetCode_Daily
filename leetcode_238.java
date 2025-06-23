// 238. Product of Array Except Self

// brute force - using two forloops to iterate through array and calculate the product every time
// tc - O(n2)
// sc - O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            int product = 1;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                product *= nums[j];
            }
            ans[i] = product;
        }

        return ans;
    }
}

// better - using prefix and suffix product arrays to store the product o(n) and calculte the answer in o(1) time
// tc - O(n)
// asc - O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];

        int prefix = 1;
        int suffix = 1;
        
        for (int i = 0; i < n; i++) {
            prefixProduct[i] = prefix;
            prefix *= nums[i];

            suffixProduct[n - 1 - i] = suffix;
            suffix *= nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }

        return ans;
    }
}

// optimal - storing the suffix product int the answer array and later storing the prefix product in the prefix variable to calculate the product in constant time
// tc - O(n)
// asc - O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            ans[n - 1 - i] = suffix;
            suffix *= nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prefix * ans[i];
            prefix *= nums[i];
        }

        return ans;
    }
}
