// 3439. Reschedule Meetings for Maximum Free Time I

// optimal - using sliding window to calculate the maximum continuos free time, if i shift x events i get x + 1 free times
// tc - O(n + 1)
// sc - O(n + 1) -- free array to store the free times betweeen the meetings


class Solution {
    public int slidingWindowMax(int[] free, int k){
        int n = free.length;
        int start = 0;
        int end = 0;

        int ans = 0;
        int currSum = 0;

        while(end < n){
            currSum += free[end];

            if(start < n && end - start + 1 > k){
                currSum -= free[start];
                start++;
            }

            ans = Math.max(currSum, ans);
            end++;
        }

        return ans;
    }
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n+1];

        free[0] = startTime[0];
        for(int i = 1; i<n; i++){
            free[i] = startTime[i] - endTime[i-1];
        }
        free[free.length - 1] = eventTime - endTime[n-1];

        return slidingWindowMax(free, k + 1);
    }
}
