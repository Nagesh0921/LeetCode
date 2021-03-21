class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int totalProfit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int start = 0;
        while(start < len-1){
            while(start < len-1 && prices[start] >= prices[start+1]){
                start++;
            }
            valley = prices[start];
            while(start < len-1 && prices[start] <= prices[start+1] ){
                start++;
            }
            peak = prices[start];
            totalProfit += peak-valley;
        }
        return totalProfit;
    }
}
