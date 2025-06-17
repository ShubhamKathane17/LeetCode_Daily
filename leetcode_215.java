// 215. Kth Largest Element in an Array
// optimal approach using heap 
// tc - O(nlogk) each element is visited once & heapify function
// sc - O(k) size of minHeap to store the elemnets

class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    //     for(int num : nums){
    //         maxHeap.add(num);
    //     }

    //     for(int i = 1; i<k; i++){
    //         maxHeap.poll();
    //     }

    //     return maxHeap.peek();
    // }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int n = nums.length;
        int start = 0;

        while (start < k) {
            minHeap.add(nums[start++]);
        }

        while (start < n) {
            if (minHeap.peek() < nums[start]) {
                minHeap.poll();
                minHeap.add(nums[start]);
            }
            start++;
        }

        return minHeap.peek();
    }
}
