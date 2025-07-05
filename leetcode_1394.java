// 1394. Find Lucky Integer in an Array

// brute force - using map to store the frequencies of the elements and then iterating on the map if the freq == num
// tc - O(n)
// sc - O(n)

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int ans = -1;
        for(int a : map.keySet()){
            if(a == map.get(a)){
                ans = Math.max(a, ans);
            }
        }

        return ans;
    }
}

// better - using 500 length array according to the constraints
// tc - O(n)
// sc - O(501)

class Solution {
    public int findLucky(int[] arr) {
        int[] map = new int[501];

        for(int a : arr){
            map[a]++;
        }

        for(int i = 500; i >= 1; i--){
            if(i == map[i]){
                return i;
            }
        }

        return -1;
    }
}

// optimal - bit manipulation only applicable if the array can be modified
// tc - O(n)
// sc - inplace

class Solution {
    public int findLucky(int[] arr) {
        for(int a : arr){
            int num = a & 65535;
            int idx = num - 1;
            
            if(num > arr.length){
                continue;
            }
            arr[idx] += (1 << 16);
        }

        for(int i = arr.length; i >= 1; i--){
            if(i == (arr[i-1] >> 16)){
                return i;
            }
        }

        return -1;
    }
}
