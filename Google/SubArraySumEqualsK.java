class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> value = new HashMap<>();
        int ans = 0, sum = 0;
        value.put(0, 1);
        for(int i=0; i<len; i++){
            sum += nums[i];
            if(value.containsKey(sum-k)){
                ans += value.get(sum-k);
            }
            value.put(sum, value.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

//Time Complexity O(N) and Space Complexity O(N)
