class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int sum = 0;
            for(int j=i; j<len; j++){
                sum+=nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

Time Complexity is O(n^2) and Space Complxity is O(1).
Runtime: 149 ms, faster than 5.07% of Java online submissions for Maximum Subarray.
Memory Usage: 41.5 MB, less than 6.22% of Java online submissions for Maximum Subarray.

This can be furhter optimized using Kadane's Algorithm. Basically Greedy Algorithm Technique.

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum=0;
        for(int i=0; i<len; i++){
            currentRunningSum += nums[i];
            if(currentRunningSum > maxSum){
                maxSum = currentRunningSum;
            }
            if(currentRunningSum < 0){
                currentRunningSum = 0;
            }
        }
        return maxSum;
    }
}  

Time Complexity is O(n) and Space Complexity is O(1)
Runtime: 1 ms, faster than 53.34% of Java online submissions for Maximum Subarray.
Memory Usage: 41.6 MB, less than 6.22% of Java online submissions for Maximum Subarray.

  
