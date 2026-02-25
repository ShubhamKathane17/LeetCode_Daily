// better - Using Integer.bitCount() to count the number of bits in the number and then sorting first according to the number of bits and then if the number of bits are same sorting according to the values
// tc - O(n log n) - sorting
// sc - O(n) - using another Integer array to store the intermediate results

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] newArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        Arrays.sort(newArr, (a, b) -> {
            if(Integer.bitCount(a) == Integer.bitCount(b)){
                return a - b;
            }
            return Integer.bitCount(a) - Integer.bitCount(b);
        });
        for(int i = 0; i < arr.length; i++){
            arr[i] = newArr[i];
        }

        return arr;
    }
}

// optimal - directly encoding both the values and the number of bits in the number it will sort the number in order of the bits first and then in order of values. after sorting decode back the values to the original
// tc - O(n log n) - sorting
// sc - O(1) - no extra space required

class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 10001;
        }

        return arr;
    }
}
