class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int remAmount, int[] count){
        if(remAmount < 0){
            return -1;
        }
        if(remAmount == 0){
            return 0;
        }
        if(count[remAmount - 1] != 0){
            return count[remAmount - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = coinChange(coins, remAmount - coin, count);
            if(result >= 0 && result < min){
                min = 1 + result;
            }
        }
        count[remAmount -1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remAmount - 1];
    }
}

//Time Complexity is O(S * n)
