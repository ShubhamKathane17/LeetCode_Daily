// 1. Two Sum

// brute force using two for loops to check for all pairs in the array if they sum up to the target
// tc - O(n2)
// sc - O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for(int i = 0; i<n; i++){
            for(int j = i+1; j < n; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}

// optimal - using map to store the previously visited element and checking if the target - (new element) is present in the map
// tc - O(n)
// sc - O(n) - map to store each and every element in the worst case

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            int ele = nums[i];
            int rem = target - ele;

            if(map.containsKey(rem)){
                return new int[]{i, map.get(rem)};
            }
            map.put(ele, i);
        }

        return new int[]{-1, -1};
    }
}

