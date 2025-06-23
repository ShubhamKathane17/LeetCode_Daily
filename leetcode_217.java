// 217. Contains Duplicate

// brute force - check for each pair if the elements are equal using two for loops
// tc - O(n2)
// sc - O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j<n; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}


// better - sort the array and check for adjacent elements
// tc - O(n + nlogn)
// sc - O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }

        return false;
    }
}


// optimal approact - use set to check if the element is repeated
// tc - O(n)
// sc - O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}

