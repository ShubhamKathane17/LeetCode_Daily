// 121. Best Time to Buy and Sell Stock
// brute force check for every pair the profit is greater than maxProfit
// tc - O(n2)
// sc - O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n; j++){
                int diff = prices[j]- prices[i];
                ans = Math.max(ans, diff);
            }
        }

        return Math.max(ans, 0);
    }
}

// optimal - store minimum and calculate the profit and update the maxProfit
// tc - O(n)
// sc - O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int price: prices){
            if(price < minPrice){
                minPrice = price;
            }
            else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
