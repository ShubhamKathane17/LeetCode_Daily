// 84. Largest Rectangle in Histogram
// optimal approach
// tc - O(n)   using stack to calculate the next and previous smaller elements using one for loop each
// sc - O(n)   2 arrays to store the index of next smaller and previous smaller elements



class Solution {
    public int[] prevSmaller(int[] nums) {
        int n = nums.length;
        int[] prevSmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                prevSmall[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            prevSmall[stack.pop()] = -1;
        }

        return prevSmall;
    }

    public int[] nextSmaller(int[] nums){
        int n = nums.length;
        int[] nextSmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                nextSmall[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nextSmall[stack.pop()] = n;
        }

        return nextSmall;
    }

    public int largestRectangleArea(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] prevSmall = prevSmaller(nums);
        int[] nextSmall = nextSmaller(nums);

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int area = nums[i] * (nextSmall[i] - prevSmall[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
