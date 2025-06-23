// 152. Maximum Product Subarray

// brute force - using three forloops to calculate the every possible product and updating the answer
// tc - O(n3)
// sc - O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int product = 1;
                for(int k = i; k <= j; k++){
                    product *= nums[k];
                }

                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

}

// optimal - using prefix and suffix variables to calculate the product in case any zero is present if suffix / prefix is equal to zero then update the prefix or suffix to 1
// tc - O(n)
// sc - O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(prefix == 0)
                prefix = 1;

            if(suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n-i-1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
