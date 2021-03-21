class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int left = 0, right = len-1;
        if(nums[right] > nums[0]){
            return nums[0];
        }
        while(left <= right){
            int midPoint = left+(right-left)/2;
            if(nums[midPoint] < nums[midPoint-1]){
                return nums[midPoint];
            }
            if(nums[midPoint] > nums[midPoint+1]){
                return nums[midPoint+1];
            }
            if(nums[midPoint] > nums[left]){
                left = midPoint+1;
            } else {
                right = midPoint-1;
            }
        }
        return -1;
    }
}

//Time Complexity is O(LogN)

//Binary Search is = Left < Mid < Right
//In Rotated Sorted Array there will be one portion which is always sorted.
//lets reverse the property of BS, 
//If Left > Mid => element is at MID
//If Mid > Right => element is at MID+1
//If not then lets search which is SOrted Part => MID > Arr[0] then Left is Sorted search in Right=> left = mid + 1
//Else right = mid - 1;
