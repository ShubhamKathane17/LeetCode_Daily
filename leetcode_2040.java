// 2040. Kth Smallest Product of Two Sorted Arrays

// optimal approach - binary search on answer and then calculating the number of elements using binary search
// tc - O(log n * m log n)
// sc - O(1)

class Solution {
    public long findCountSmallest(int[] nums1, int[] nums2, long midProduct){
        long count = 0;
        int n = nums2.length;

        for(int num : nums1){
            if(num >= 0){
                int start = 0;
                int end = n-1;
                int pos = -1;

                while(start <= end){
                    int mid = start + (end - start) / 2;
                    long prod = 1L * num * nums2[mid];

                    if(prod <= midProduct){
                        pos = mid;
                        start = mid + 1; 
                    }else{
                        end = mid - 1;
                    }
                }
                count += (pos + 1);
            }else{
                int start = 0;
                int end = n-1;
                int pos = n;

                while(start <= end){
                    int mid = start + (end - start) / 2;
                    long prod = 1L * num * nums2[mid];

                    if(prod <= midProduct){
                        pos = mid;
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
                count += (n - pos);
            }
        }
        return count;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long ans = 0;

        long start = -1_000_000_0000L;
        long end = 1_000_000_0000L;

        while(start <= end){
            long mid = start + (end - start) / 2;
            long count = findCountSmallest(nums1, nums2, mid);

            if(count >= k){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
