// 33. Search in Rotated Sorted Array

// brute force - using linear search
// tc - O(n)
// sc - O(1)

class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }
}

// optimal using modified binary search
// tc - O(log n)
// sc - O(1)

class Solution {
    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
          
            if (nums[start] <= nums[mid]) {
                if(nums[start] <= target && nums[mid] >= target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            } 
            else {
                if(nums[end] >= target && nums[mid] <= target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}
