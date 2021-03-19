class Solution {
    public int largestRectangleArea(int[] heights) {
        //To form an rectangle we can take min height of the adjustant 
        int len = heights.length, maxArea = 0;
        for(int i=0; i<len; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i; j<len; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }
}

//Time Complexity O(N^2) and Space Complexity O(1)

//Better Solution is using Data Structure.
//Basic Idea is, if we can store incoming element from array and compare it next Element.
//We can use Stack!!! 

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, len = heights.length;
        stack.push(-1);
        for(int i=0; i<len; i++){
            while((stack.peek() != -1) && heights[stack.peek()] >= heights[i]){
                int currentHt = heights[stack.pop()];
                int currentWd = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHt*currentWd);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int currentHt = heights[stack.pop()];
            int currentWd = len - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHt*currentWd);
        }
        return maxArea;
    }
}

//Time and Space Complexity is O(N)
