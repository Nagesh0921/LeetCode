class Solution {
    public int findPeakElement(int[] nums) {
        int peak = nums[0], peakIndex = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > peak){
                peak = nums[i];
                peakIndex = i;
            }
        }
        return peakIndex;
        // int left = 0, right = nums.length-1;
        // while(left < right){
        //     int mid = (left + right)/2;
        //     if(nums[mid] > nums[mid+1]){
        //         right = mid;
        //     } else {
        //         left = mid+1;
        //     }
        // }
        // return left;
    }
}

//Time Complexity is O(log n)
