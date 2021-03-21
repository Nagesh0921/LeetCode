class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int midPoint = left + (right - left)/2;
            if(nums[midPoint] == target){
                return midPoint;
            } else if(nums[midPoint] >= nums[left]){ //Modified BS property to check which part to be searched in
                if(target >= nums[left] && nums[midPoint] > target){
                    //search in Right
                    right = midPoint-1;
                } else {
                    left = midPoint+1;
                }
            } else {
                if(target <= nums[right] && nums[midPoint] < target){
                    left = midPoint+1;
                } else {
                    right = midPoint-1;
                }
            }
        }
        return -1;
    }
}
