// 239. Sliding Window Maximum
// brute force - calculating maximum for window size k for each element in the nums array
// tc - O(n2) - 2 for loops for iterating in worst case every element is visited n times 
// sc - O(n) - List to store the answer for each iteration

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n - k + 1; i++) {
            int maxi = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            ans[idx++] = maxi;
        }
        return ans;
    }
}

// better - using maxHeap of size k to keep track of max element
// tc - O(nlogk) - n - visiting each element log k - heapify
// sc - O(n + k) - n - storing elements in list & k - maxheap size

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 1 || k == 1) {
            return nums;
        }
        int[] ans = new int[n-k+1];
        int idx = 0;
        
        int start = 0;
        int end = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));

        for (end = 0; end < k; end++) {
            maxHeap.add(nums[end]);
        }
        ans[idx++] = maxHeap.peek();

        while (end < n) {
            maxHeap.remove(nums[start++]);
            maxHeap.add(nums[end++]);
            ans[idx++] = maxHeap.peek();
        }
        return ans;
    }
}


// optimal approach
// usign deque - add new element to the end and remove all the elements from end which are less than the element the first element gives the sliding window maximum always check the index if it is out of the window
//  tc - O(n) - each element is visited only once in the nums array. Pushing and polling from deque constant time
//  sc - O(k) - list for storing the elements in deque O(n) in worst case if k == n 

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 1 || k == 1) {
            return nums;
        }

        int[] ans = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        for (int i = k; i < n; i++) {
            ans[idx++] = nums[dq.peekFirst()];

            if (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        ans[idx++] = nums[dq.peekFirst()];
        return ans;
    }
}
