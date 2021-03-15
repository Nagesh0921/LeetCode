class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int mod = x%10;
            x /= 10;
            //overflow
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && mod > 7){
                return 0;
            }
            //underflow
            if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE && mod < -8){
                return 0;
            }
            result = result * 10 + mod;
        }
        return result;
    }
}

//Time Complexity O(LogX)
