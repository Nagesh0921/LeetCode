class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int maxValue = nums[0];
        int minValue = nums[0];
        int result = maxValue;
        for(int i=1; i<len; i++){
            int curVal = nums[i];
            int tempMax = Math.max(curVal, Math.max(curVal*maxValue, curVal*minValue));
            minValue = Math.min(curVal, Math.min(curVal*maxValue, curVal*minValue));
            maxValue = tempMax;
            
            result = Math.max(result, maxValue);
        }
        return result;
    }
}

//This is Dynamic Programming: (Modified Kadane's Algo for Product) Corner Cases were all negative numbers, negative and zeros
//Idea is to have max value at each position and min value at each position
// Time Complexity O(N) Space Complexity O(1)
//Runtime: 1 ms, faster than 93.81% of Java online submissions for Maximum Product Subarray.
//Memory Usage: 38.4 MB, less than 94.11% of Java online submissions for Maximum Product Subarray.

//Brute Force
