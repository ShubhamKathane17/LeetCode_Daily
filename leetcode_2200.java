// 2200. Find All K-Distant Indices in an Array

// brute force - using two forloops to calculate the distance between elements and key and checking if the distance is less than or equal to k
// tc - O(n2)
// sc - O(1)

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(nums[j] == key){
                    if(Math.abs(j-i) <= k){
                        ans.add(i);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

// better - using list to store the indices of key and iterating on the indices list to get the minimum distance which is <= k
// tc - O(n2) - worst case        O(n) - average case 
// sc - O(n) - using list to store the key 

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num == key){
                indices.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i<n; i++){
            for(int idx : indices){
                if(Math.abs(idx - i) <= k){
                    ans.add(i);
                    break;
                }
            }

        }

        return ans;
    }
}


// optimal - using two pointers to calculate the minimum distance between the elements and key
// tc - O(n)
// sc - O(n)

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == key) {
                indices.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        int listIdx = 0;

        for (int i = 0; i < n; i++) {
            while (listIdx < indices.size() && (i - indices.get(listIdx)) < 0
                    && Math.abs(i - indices.get(listIdx)) > k) {
                i++;
            }
            while (listIdx < indices.size() && (i - indices.get(listIdx)) > 0
                    && Math.abs(i - indices.get(listIdx)) > k) {
                listIdx++;
            }
            if (listIdx < indices.size() && Math.abs(i - indices.get(listIdx)) <= k) {
                ans.add(i);
            }
        }

        return ans;
    }
}

