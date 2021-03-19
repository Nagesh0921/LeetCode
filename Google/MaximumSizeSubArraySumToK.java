class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE, currentSum = 0;
        for(int i=0; i<nums.length; i++){
            currentSum += nums[i];
            if(currentSum == k){
                ans = i + 1;
            } else if(map.containsKey(currentSum-k)){
                ans = Math.max(ans, i-map.get(currentSum-k)); 
            }
            if(!map.containsKey(currentSum)){
                map.put(currentSum, i);
            }
        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }
}
