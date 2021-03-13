class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
// Time Complexity O(nlog n) Space Complexity O(log n)
//Runtime: 4 ms, faster than 18.50% of Java online submissions for Squares of a Sorted Array.
//Memory Usage: 52.7 MB, less than 15.26% of Java online submissions for Squares of a Sorted Array.

// We can reduce Time complexity and Space Complexity using "Two Pointer" technique

class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int left = 0, right = len-1;
        for(int i=len-1; i>=0; i--){
            int sqr = 0;
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                sqr = nums[right];
                right--;
            } else {
                sqr = nums[left];
                left++;
            }
            result[i] = sqr*sqr;
        }
        return result;
    }
}

//Time Complexity is O(n) and Space Complexity is O(n)
//Runtime: 2 ms, faster than 64.12% of Java online submissions for Squares of a Sorted Array.
//Memory Usage: 53.3 MB, less than 7.06% of Java online submissions for Squares of a Sorted Array.
