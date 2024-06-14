class Solution {
    public int maxProfit(int[] prices) {
        int prof = Integer.MIN_VALUE;
        int n = prices.length;
        int buy = prices[0];
        for(int i = 0; i < n; i++) {
            buy = Math.min(buy, prices[i]);
            prof = Math.max(prof, prices[i] - buy);
        }
        return prof;
    }
}