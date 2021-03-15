class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return maxArea;
    }
}
// Classic Example of Time Limit Exceeds and why Time Complexity is Imp
//Time Complexity O(N^2) and Space Complexity O(1)

//Optimized Code can be write using 2 Pointers, basically
//We can increase our left side if value a arr[left] <= arr[right] else decrease right

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int i=0,j=len-1;
        while(i<j){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}

//Time complexity is O(N) and Space Complexity O(1)
