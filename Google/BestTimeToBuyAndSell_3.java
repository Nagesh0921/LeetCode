class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        
        int leftMin = prices[0];
        int rightMax = prices[len-1];
        
        int[] left_side = new int[len];
        int[] right_side = new int[len + 1];
        for(int i=1; i<len; i++){
            left_side[i] = Math.max(left_side[i-1], prices[i]-leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }
        
        for(int r = len-1-1; r>=0; r--){
            right_side[r] = Math.max(right_side[r+1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }
        
        int maxProfit = 0;
        for(int i=0; i<len; i++){
            maxProfit = Math.max(maxProfit, left_side[i] + right_side[i+1]);
        }
        return maxProfit;
    }
}
