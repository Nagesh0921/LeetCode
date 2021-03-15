class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetValue = new HashMap<>();
        int[] result = new int[2];
        int len = nums.length;
        for(int i=0; i<len; i++){
            int complement = target-nums[i];
            if(targetValue.containsKey(complement)){
                return new int[]{targetValue.get(complement), i};
            }
            targetValue.put(nums[i], i);
        }
        return result;
    }
}

//This problem can be solved using 2 loops with Time Complexity O(N^2) and Space Complexity O(1)
//The above one is using a trick of Mathematics to get complement of a number and using extra space.
//Time Complexity is O(N) and Space Complexity O(N)

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
//Memory Usage: 38.8 MB, less than 92.80% of Java online submissions for Two Sum.

//This can be further optimized using: Two Pointers if the given array is SORTED!!!

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        
        while(left<right){
            int currentSum = numbers[left]+numbers[right];
            if(currentSum == target){
                return new int[]{left+1,right+1};
            }
            if(currentSum > target){
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}

//Time Complexity O(N) and Space Complexity O(1)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
//Memory Usage: 39.4 MB, less than 32.58% of Java online submissions for Two Sum II - Input array is sorted.



