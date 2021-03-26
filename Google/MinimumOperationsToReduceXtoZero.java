class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i : nums){
            total += i;
        }
        int leftIndex = 0, rightIndex = 0, len = nums.length, sum = 0, ans = -1;
        for(;rightIndex<len; rightIndex++){
            sum += nums[rightIndex];
            while(sum > (total - x) && leftIndex <= rightIndex){
                sum -= nums[leftIndex];
                leftIndex++;
            }
            if(total - x == sum){
                ans = Math.max(ans, rightIndex-leftIndex+1);
            }
        }
        return ans != -1 ? len-ans : -1;
    }
}

//Two Pointer
