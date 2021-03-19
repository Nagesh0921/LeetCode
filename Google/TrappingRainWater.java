class Solution {
    public int trap(int[] height) {
        int result = 0, len = height.length;
        int left = 0, right = len-1, maxLeft = 0, maxRight = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                } else {
                    result += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right] >= maxRight){
                    maxRight = height[right];
                } else {
                    result += maxRight - height[right];
                }
                right--;
            }
        }
        return result;
    }
}

//This is using Two Pointers Approach. Time Complexity is O(n) and Space Complexity is O(1).
