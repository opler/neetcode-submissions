class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftMinBuy = new int[n];
        int[] rightMaxSell = new int[n];
        leftMinBuy[0] = prices[0];
        rightMaxSell[n-1] = prices[n-1];

        for(int i = 1; i < n; i++) {
            leftMinBuy[i] = Math.min(leftMinBuy[i-1], prices[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            rightMaxSell[i] = Math.max(rightMaxSell[i+1], prices[i]);
        }
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, rightMaxSell[i] - leftMinBuy[i]);
        }
        return maxProfit;
    }
}
