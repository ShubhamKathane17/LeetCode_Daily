// 268. Missing Number

// brute force - sorting the array and comparing with the indices
// tc- O(nlogn)
// sc - O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;
    }
}


// optimal - summing up the numbers and subtracting from the sum of the first n natural numbers
// tc - O(n)
// sc - O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums)
            sum += num;

        int nSum = n * (n + 1)/2;

        return nSum - sum;
    }
}
