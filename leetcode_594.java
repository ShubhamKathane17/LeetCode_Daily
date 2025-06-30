// 594. Longest Harmonious Subsequence

// opitmal approach - using map to store the count of the numbers and checking for each number and number + 1 as the harmonius array would only contain 2 elements
// tc - O(n)
// sc - O(n) - map to store the count of the numbers

class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for(int num : map.keySet()){
            if(map.containsKey(num + 1)){
                ans = Math.max(ans, (map.get(num) + map.get(num + 1)));
            }
        }

        return ans;
    }
}
