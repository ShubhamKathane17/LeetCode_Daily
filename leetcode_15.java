// 15. 3Sum

// brute force - using three forloops to iterate through every triplet and checking if the elements sum up to the target & using set to encounter the duplicates
// tc - O(n3)
// asc - O(n) - using set

class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(n<3)
            return new ArrayList<>();

        for(int i = 0; i < n - 2; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }    

        return new ArrayList<>(ans);
    }
}


// optimal - sorting the array and then calculating the two sum for every element skipping the duplicates
// tc - O(n2)
// asc - O(1)

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void twoSum(int[] nums, int target, int start, int end) {
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }

                List<Integer> list = Arrays.asList(-1 * target, nums[start], nums[end]);
                ans.add(list);
                start++;
                end--;
            }
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if (n < 3)
            return new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            twoSum(nums, target, i + 1, n - 1);
        }

        return ans;
    }
}
