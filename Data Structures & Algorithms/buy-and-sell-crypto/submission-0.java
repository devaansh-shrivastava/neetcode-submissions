class Solution {
    public int maxProfit(int[] prices) {
        int i = 1;

        int buyPrice = prices[0];
        int buyIndex = 0;
        int profit = 0;

        while(i < prices.length) {
            if(prices[i] < buyPrice) { buyIndex = i; buyPrice = prices[i]; }
            profit = Math.max(profit, prices[i] - buyPrice);
            i++;
        }

        return profit;
    }
}
