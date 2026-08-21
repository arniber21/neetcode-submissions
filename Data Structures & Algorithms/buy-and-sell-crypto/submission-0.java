class Solution {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int minSoFar = prices[0];
        for(int price: prices) {
            int profit = price - minSoFar;
            if(profit > maxSoFar) maxSoFar = profit;
            if(price < minSoFar) minSoFar = price;
        }
        return maxSoFar;
    }
}
