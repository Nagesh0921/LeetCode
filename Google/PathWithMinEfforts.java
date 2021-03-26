class Solution {
    
    int[] rowDir = {1,0,-1,0};
    int[] colDir = {0,1,0,-1};
    
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000000, result = right;
        while(left <= right){
            int mid = (left+right)/2;
            if(dfsWalk(heights, mid)){
                result = Math.min(result, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }
    
    public boolean dfsWalk(int[][] heights, int mid){
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] isVisited = new boolean[row][col];
        return canReachDestination(heights, 0, 0, row, col, mid, isVisited);
    }
    
    public boolean canReachDestination(int[][] heights, int currRow, int currCol, int row, int col, int mid, boolean[][] isVisited){
        if(currRow == row-1 && currCol == col-1){
            return true;
        }
        isVisited[currRow][currCol] = true;
        for(int i=0; i<4; i++){
            int newRow = currRow + rowDir[i];
            int newCol = currCol + colDir[i];
            if(newRow >= 0 && newRow <= row-1 && newCol >= 0 && newCol <= col-1 && !isVisited[newRow][newCol]){
                int currentDiff = Math.abs(heights[newRow][newCol] - heights[currRow][currCol]);
                if(currentDiff <= mid){
                    return canReachDestination(heights, newRow, newCol, row, col, mid, isVisited);
                }
            }
        }
        return false;
    }
}

//Time Complexity is O(R*C)
