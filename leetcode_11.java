// 11. Container With Most Water

// brute force - iterating using two loops to calculate the maximum area for each element as start
// tc - O(n2)
// sc - O(1)

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int start = i;
            int end = n - 1;

            while (start < end) {
                int breadth = Math.min(height[start], height[end]);
                int length = end - start;

                int water = breadth * length;

                ans = Math.max(water, ans);
                end--;
            }
        }

        return ans;
    }
}

// optimal using two pointers incrementing start / decrementing end by comparing both the elements 
// tc - O(n)
// sc - O(1)

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = Integer.MIN_VALUE;

        int start = 0;
        int end = n-1;

        while(start < end){
            int length = end - start;
            int breadth = Math.min(height[start], height[end]);

            int area = length * breadth;
            ans = Math.max(ans, area);

            if(height[start] <=  height[end]){
                start++;
                continue;
            }else{
                end--;
                continue;
            }
        }

        return ans;
    }
}
