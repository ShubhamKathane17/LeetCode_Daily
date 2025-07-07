// 1353. Maximum Number of Events That Can Be Attended

// optimnal - using sorting the events in the ascending order and minHeap to store the ending time of the events
// tc - O(n log n)
// sc - O(n)

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int day = events[0][0];
        int i = 0;
        int count = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (!minHeap.isEmpty() || i < n) {
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]);
                i++;
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }

            day++;

            while(!minHeap.isEmpty() && minHeap.peek() < day){
                minHeap.poll();
            }

        }

        return count;
    }
}
