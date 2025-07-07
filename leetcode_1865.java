// 1865. Finding Pairs With a Certain Sum

// optimal - jo bola hai vo kr do using map to store the frequencies of the 2nd array bcoz its size could be 10^6 and then twosum directly for each element of nums1
// tc - O(n1 + n2)
// sc - O(n2) - map to store the frequencies


class FindSumPairs {
    int[] nums1;
    int[] nums2;

    Map<Integer, Integer> map = new HashMap(); // sc - O(n2)

    public FindSumPairs(int[] nums1, int[] nums2) { // O(n1 + n2)
        this.nums1 = nums1;
        this.nums2 = nums2;

        for(int i : nums2){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }
    
    public void add(int index, int val) { // O(1)
        map.put(nums2[index], map.get(nums2[index]) - 1);

        nums2[index] += val;

        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) { // O(n1)
        int ans = 0;
        for(int i : nums1){
            ans += map.getOrDefault(tot - i, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
