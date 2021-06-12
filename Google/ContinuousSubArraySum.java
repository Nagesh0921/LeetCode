class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        int length = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //This condition is needed to handle Zero Case. 23+2+4+6 = 35%7 = 0 hence, -1 get value will give true.
        map.put(0, -1);
        for(int i=0; i<length; i++){
            sum += nums[i];
            int mod = (k==0) ? sum : (sum % k);
            if(map.containsKey(mod) && i-map.get(mod) > 1){
                return true;
            }
            map.putIfAbsent(mod, i);
        }
        return false;
    }
}

//Time Complexity O(N) and Space Complexity O(N)
